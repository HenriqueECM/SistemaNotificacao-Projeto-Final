package org.example.model;

public class Aluno {
    private int id;
    private String matricula;
    private String status;
    private String turma;
    private String nome;

    public Aluno(int id, String matricula, String status, String turma, String nome) {
        this.id = id;
        this.matricula = matricula;
        this.status = status;
        this.turma = turma;
        this.nome = nome;
    }

    public Aluno(String matricula, String status, String turma, String nome) {
        this.matricula = matricula;
        this.status = status;
        this.turma = turma;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getStatus() {
        return status;
    }

    public String getTurma() {
        return turma;
    }

    public String getNome() {
        return nome;
    }

    
}
