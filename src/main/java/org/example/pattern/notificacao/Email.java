package org.example.pattern.notificacao;

public class Email implements Notificador {
    @Override
    public void enviar(String mensagem) {
        System.out.println("Email: " + mensagem);
    }
}
