package org.example.repository;

import org.example.model.User;

import java.sql.SQLException;

public class UserDAO {
    public void cadastro (User user) throws SQLException {
        String query = "INSERT INTO User (nome, email, senha, tipo) VALUES (?,?,?,'ALUNO')";
    }
}
