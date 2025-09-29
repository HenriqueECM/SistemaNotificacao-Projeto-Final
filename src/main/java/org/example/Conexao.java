package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    String url = "";
    String User = "root";
    String password = "root";

    public Connection conectar() throws SQLException{
        return DriverManager.getConnection(url, User, password);
    }
}
