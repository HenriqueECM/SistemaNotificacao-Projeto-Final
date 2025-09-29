package org.example.pattern.facade;

import org.example.pattern.notificacao.EmailFactory;
import org.example.pattern.notificacao.Notificador;
import org.example.pattern.notificacao.NotificadorFactory;
import org.example.pattern.notificacao.SmsFactory;

public class NotificacaoFacade {
    public void notificarAluno(Aluno aluno, String mensagem, String tipo) {
        NotificadorFactory factory;
        if(tipo.equalsIgnoreCase("EMAIL")){
            factory = new EmailFactory();
        } else {
            factory = new SmsFactory();
        }

        Notificador n = factory.criarNotificador();
        n.enviar("Aluno: " + aluno.getNome() + " - " + mensagem);
    }
}

