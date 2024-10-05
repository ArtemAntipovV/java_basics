package ru.skillbox;

import ru.skillbox.notification.EmailNotification;

public class Main {
    public static void main(String[] args) {

        EmailNotification email = new EmailNotification();
        email.setSubject("Успешная регистрация!");
        email.setEmailMessage("Спасибо за регистрацию на сервисе!");
        email.addReceiver("mail@mail.ru");
        System.out.println(email.toString());

    }
}
