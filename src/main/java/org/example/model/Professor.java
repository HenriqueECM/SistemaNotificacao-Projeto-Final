package org.example.model;

public class Professor {
    
    private int id;
    private String telefone;
    private String cpf;
    private String email;
    private String senha;

    public Professor(int id, String telefone, String cpf, String email, String senha) {
        this.id = id;
        this.telefone = telefone;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
    }

    public Professor(String telefone, String cpf, String email, String senha) {
        this.telefone = telefone;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    
}
