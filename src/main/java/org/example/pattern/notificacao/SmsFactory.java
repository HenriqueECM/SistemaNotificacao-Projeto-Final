package org.example.pattern.notificacao;

// Fábrica concreta para SMS
public class SmsFactory extends NotificadorFactory{
    @Override
    public Notificador criarNotificador() {
        return new SMS();
    }
}
