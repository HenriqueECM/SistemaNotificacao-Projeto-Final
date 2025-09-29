package org.example.pattern.notificacao;

// Implementações concretas
public class SMS implements Notificador{
    @Override
    public void enviar(String mensagem) {
        System.out.println("SMS: " + mensagem);
    }
}
