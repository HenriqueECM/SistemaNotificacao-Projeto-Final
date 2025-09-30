package org.example.repository;

import org.example.Conexao;
import org.example.model.Aluno;
import org.example.model.Presenca;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PresencaDAO {
    public void registrar(int alunoId, int unidadeId, LocalDate data, String status, Integer professorId) throws SQLException {
        String query = "INSERT INTO Presenca (aluno_id, unidade_curricular_id, data_avaliacao, status, professor_id) VALUES (?, ?, ?, ?, ?)" +
                "ON DUPLICATE KEY UPDATE status = VALUES(status), professor_id = VALUES(professor_id), updated_at = NOW()";

        try (Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setInt(1, alunoId);
            stmt.setInt(2, unidadeId);
            stmt.setDate(3, Date.valueOf(data));
            stmt.setString(4, status);
            if (professorId == null){
                stmt.setNull(5, Types.INTEGER);
            } else {
                stmt.setInt(5, professorId);
            }

            stmt.executeUpdate();
        }
    }

    public List<Aluno> getAusentesPorData(LocalDate data, int unidadeId) throws SQLException {
        String sql = "SELECT u.id, u.nome, u.email FROM User u " +
                "JOIN Aluno a ON u.id = a.id " +
                "JOIN Presenca p ON p.aluno_id = a.id " +
                "WHERE p.data_avaliacao = ? AND p.unidade_curricular_id = ? AND p.status = 'AUSENTE'";
        List<Aluno> result = new ArrayList<>();

        try (Connection conn = Conexao.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDate(1, Date.valueOf(data));
            ps.setInt(2, unidadeId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Aluno a = new Aluno();
                    a.setId(rs.getInt("id"));
                    a.setNome(rs.getString("nome"));
                    a.setEmail(rs.getString("email"));
                    result.add(a);
                }
            }
        }
        return result;
    }
}
