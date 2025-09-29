package org.example.pattern.notificacao;

public class SmsFactory extends NotificadorFactory{
    @Override
    public Notificador criarNotificador() {
        return new SMS();
    }
}
