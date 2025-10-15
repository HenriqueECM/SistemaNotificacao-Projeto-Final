package org.example.controller;

import org.example.model.User;
import org.example.repository.UserDAO;
import org.example.service.AuthService;

public class LoginController {
    private final AuthService authService;

    public LoginController() {
        this.authService = new AuthService(new UserDAO());
    }

    public void login(String email, String senha) {
        try {
            User user = authService.login(email, senha);
            if (user != null) {
                System.out.println("Login bem-sucedido!");
                System.out.println("Tipo de usuário: " + user.getTipo());
            } else {
                System.out.println("Credenciais inválidas.");
            }
        } catch (Exception e) {
            System.out.println("Erro no login: " + e.getMessage());
        }
    }
}