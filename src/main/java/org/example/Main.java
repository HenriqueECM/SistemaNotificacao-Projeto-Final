package org.example;

import org.example.controller.AlunoController;
import org.example.controller.CadastroController;
import org.example.controller.LoginController;
import org.example.controller.ProfessorController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CadastroController cadastroController = new CadastroController();
        LoginController login = new LoginController();

        System.out.println("=== SISTEMA DE LOGIN E CADASTRO ===");
        System.out.println("1 - Cadastrar aluno");
        System.out.println("2 - Cadastrar professor");
        System.out.println("3 - Fazer login");
        System.out.print("Escolha: ");
        int opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao) {
            case 1 -> {
                System.out.print("Nome: ");
                String nome = sc.nextLine();
                System.out.print("Email: ");
                String email = sc.nextLine();
                System.out.print("Senha: ");
                String senha = sc.nextLine();
                System.out.print("Matrícula: ");
                String matricula = sc.nextLine();
                System.out.print("Turma: ");
                String turma = sc.nextLine();
                cadastroController.cadastrarAluno(nome, email, senha, matricula, turma);
            }
            case 2 -> {
                System.out.print("Nome: ");
                String nome = sc.nextLine();
                System.out.print("Email: ");
                String email = sc.nextLine();
                System.out.print("Senha: ");
                String senha = sc.nextLine();
                System.out.print("Telefone: ");
                String telefone = sc.nextLine();
                System.out.print("CPF: ");
                String cpf = sc.nextLine();
                cadastroController.cadastrarProfessor(nome, email, senha, telefone, cpf);
            }
            case 3 -> {
                System.out.print("Email: ");
                String email = sc.nextLine();
                System.out.print("Senha: ");
                String senha = sc.nextLine();
                login.login(email, senha);
            }
            default -> System.out.println("Opção inválida.");
        }
    }
}