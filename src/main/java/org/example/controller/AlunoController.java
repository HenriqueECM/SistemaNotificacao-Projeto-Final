package org.example.controller;

import org.example.model.Aluno;
import org.example.repository.AlunoDAO;
import org.example.repository.UserDAO;
import org.example.service.AlunoService;

public class AlunoController {
    private final AlunoService alunoService;

    public AlunoController() {
        this.alunoService = new AlunoService(new UserDAO(), new AlunoDAO());
    }

    public void cadastrarAluno(String nome, String email, String senha, String matricula, String turma) {
        try {
            Aluno aluno = new Aluno();
            aluno.setNome(nome);
            aluno.setEmail(email);
            aluno.setSenha(senha);
            aluno.setMatricula(matricula);
            aluno.setTurma(turma);
            alunoService.cadastrarAluno(aluno);
            System.out.println("Aluno cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar aluno: " + e.getMessage());
        }
    }
}
