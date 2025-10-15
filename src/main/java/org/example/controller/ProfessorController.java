package org.example.controller;

import org.example.model.Aluno;
import org.example.model.Professor;
import org.example.repository.ProfessorDAO;
import org.example.repository.UserDAO;
import org.example.service.ProfessorService;

import java.sql.SQLException;
import java.time.LocalDate;

public class ProfessorController {
//    private final RegistroPresencaController registro;
    private final ProfessorService professorService;

    public ProfessorController() {
        this.professorService = new ProfessorService(new UserDAO(), new ProfessorDAO());

    }

    public void cadastrarProfessor(String nome, String email, String senha, String telefone, String cpf) {
        try {
            Professor prof = new Professor();
            prof.setNome(nome);
            prof.setEmail(email);
            prof.setSenha(senha);
            prof.setTelefone(telefone);
            prof.setCpf(cpf);
            professorService.cadastrarProfessor(prof);
            System.out.println("Professor cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar professor: " + e.getMessage());
        }
    }

//    public void marcarFaltaAluno(Aluno aluno, LocalDate data, int unidadeId, Integer professorId) {
//        try {
//            System.out.println(STR."Professor está marcando falta do aluno \{aluno.getNome()}");
//            registro.marcarFalta(aluno, data, unidadeId, professorId);
//        } catch (SQLException e) {
//            // tratar erro (rollback já feito dentro do DAO se usou transação explicita)
//            e.printStackTrace();
//        }
//    }
}