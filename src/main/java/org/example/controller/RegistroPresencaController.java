package org.example.controller;

import org.example.model.Aluno;
import org.example.pattern.facade.NotificacaoFacade;
import org.example.pattern.observer.Observador;
import org.example.repository.PresencaDAO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.StringTemplate.STR;

public class RegistroPresencaController {
    private final PresencaDAO presencaDAO;
    private final NotificacaoFacade notificacaoFacade;
    private final List<Observador> observadores = new CopyOnWriteArrayList<>();
    private final ExecutorService executor = Executors.newFixedThreadPool(4);

    public RegistroPresencaController(PresencaDAO dao, NotificacaoFacade facade) {
        this.presencaDAO = dao;
        this.notificacaoFacade = facade;
    }

    public void adicionarObservador(Observador obs) {
        observadores.add(obs);
    }
    public void removerObservador(Observador obs) {
        observadores.remove(obs);
    }

    // Marca falta, persiste e notifica (sincrono no DB, notificação assíncrona opcional)
    public void marcarFalta(Aluno aluno, LocalDate data, int unidadeId, Integer professorId) throws SQLException {
        // 1) Persistir no banco (garantir que DB registre antes de notificar)
        presencaDAO.registrar(aluno.getId(), unidadeId, data, "AUSENTE", professorId);

        // 2) Atualiza estado em memória (se precisar)
        aluno.setStatus("AUSENTE");

        // 3) Notificar observadores in-app (sincrono)
        String msgObservador = STR."Aluno \{aluno.getNome()} foi marcado como AUSENTE em \{data}";
        for (Observador obs : observadores) {
            obs.atualizar(msgObservador);
        }

        // 4) Notificação externa (Email/SMS) — use o facade. Envia async para não travar a thread do controller.
        String msgExtern = STR."Você foi marcado ausente na avaliação de \{data} (unidade \{unidadeId})";
        executor.submit(() -> {
            try {
                // Tipo pode vir da configuração do aluno (email/sms) ou do admin
                notificacaoFacade.notificarAluno(aluno, msgExtern, "EMAIL");
            } catch (Exception e) {
                // log e retry/backoff se necessário
                e.printStackTrace();
            }
        });
    }

    // Exemplo: enviar notificações para todos ausentes de uma data (batch)
    public void notificarAusentesDe(LocalDate data, int unidadeId, String tipo) throws SQLException {
        List<Aluno> ausentes = presencaDAO.getAusentesPorData(data, unidadeId);
        for (Aluno a : ausentes) {
            String mensagem = STR."Você está ausente na avaliação de \{data}. Procure administração para segunda chamada.";
            notificacaoFacade.notificarAluno(a, mensagem, tipo);
        }
    }

    // fechar executor quando encerrar aplicação
    public void shutdown() {
        executor.shutdown();
    }
}