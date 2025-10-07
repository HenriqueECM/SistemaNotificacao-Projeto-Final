package org.example.model;

public class Aluno {
    private int id;
    private String matricula;
    private String status;
    private String turma;

    public Aluno(int id, String matricula, String status, String turma) {
        this.id = id;
        this.matricula = matricula;
        this.status = status;
        this.turma = turma;
    }

    public Aluno(String matricula, String status, String turma) {
        this.matricula = matricula;
        this.status = status;
        this.turma = turma;
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

    public void setEmail(String email) {
    }
}
