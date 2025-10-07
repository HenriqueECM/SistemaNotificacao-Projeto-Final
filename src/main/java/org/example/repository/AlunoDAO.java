package org.example.repository;

import org.example.Conexao;
import org.example.model.Aluno;
import org.example.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AlunoDAO {
    public void cadastro (Aluno aluno, User user) throws SQLException {
        String queryUser = "INSERT INTO User (nome, email, senha, tipo) VALUES (?,?,?, 'ALUNO";

        String queryAluno = "INSERT INTO Aluno (matricula, status, turma) VALUES (?,?,?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(queryUser)){

            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getSenha());

            stmt.executeUpdate();

        }

        try (Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(queryAluno)){

            stmt.setString(1, aluno.getMatricula());
            stmt.setString(2, aluno.getStatus());
            stmt.setString(3, aluno.getTurma());

            stmt.executeUpdate();

        }
    }
}