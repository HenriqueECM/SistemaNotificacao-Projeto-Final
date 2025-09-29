package org.example.pattern.notificacao;

// Fábrica concreta para Email
public class EmailFactory extends NotificadorFactory {
    @Override
    public Notificador criarNotificador() {
        return new Email();
    }
}
