package org.example.pattern.observer;

import org.example.model.Aluno;

// Observador concreto: aluno
public class AlunoObservador implements Observador{
    private Aluno aluno;
    public AlunoObservador(Aluno aluno) {
        this.aluno = aluno;
    }
    @Override
    public void atualizar(String mensagem) {
        System.out.println("Notificação para " + aluno.getNome() + ": " + mensagem);
    }
}
