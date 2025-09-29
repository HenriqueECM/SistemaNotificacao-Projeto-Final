package org.example.pattern.notificacao;

public class EmailFactory extends NotificadorFactory {
    @Override
    public Notificador criarNotificador() {
        return new Email();
    }
}
