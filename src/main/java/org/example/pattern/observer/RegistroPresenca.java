package org.example.pattern.observer;

import org.example.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class RegistroPresenca {
    private List<Observador> observadores = new ArrayList<>();

    // Adiciona aluno observador
    public void adicionar(Observador o) {
        observadores.add(o);
    }

    // Marca falta e notifica automaticamente
    public void marcarFalta(Aluno a) {
        a.setStatus("AUSENTE");
        for(Observador obs : observadores) {
            obs.atualizar("Você está ausente na avaliação de hoje!");
        }
    }
}
