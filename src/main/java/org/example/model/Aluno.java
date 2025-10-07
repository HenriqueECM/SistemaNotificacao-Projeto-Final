package org.example.model;

public class Aluno {
    private int id;
    private String matricula;
    private String status;
    private String turma;
    private String nome;

    public Aluno(int id, String matricula, String status, String turma) {
        this.id = id;
        this.matricula = matricula;
        this.status = status;
        this.turma = turma;
        this.nome = nome;
    }

    public Aluno(String matricula, String status, String turma) {
        this.matricula = matricula;
        this.status = status;
        this.turma = turma;
        this.nome = nome;
    }

    public Aluno() {

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

    public void setId(int id) {
        this.id = id;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
    }
}
