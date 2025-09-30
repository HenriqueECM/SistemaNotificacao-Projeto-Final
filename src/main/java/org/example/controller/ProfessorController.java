package org.example.controller;

import org.example.model.Aluno;

import java.sql.SQLException;
import java.time.LocalDate;

public class ProfessorController {
    private final RegistroPresencaController registro;

    public ProfessorController(RegistroPresencaController registro) {
        this.registro = registro;
    }

    public void marcarFaltaAluno(Aluno aluno, LocalDate data, int unidadeId, Integer professorId) {
        try {
            System.out.println(STR."Professor está marcando falta do aluno \{aluno.getNome()}");
            registro.marcarFalta(aluno, data, unidadeId, professorId);
        } catch (SQLException e) {
            // tratar erro (rollback já feito dentro do DAO se usou transação explicita)
            e.printStackTrace();
        }
    }
}