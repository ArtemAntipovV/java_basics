package ru.skillbox;

import ru.skillbox.notification.EmailNotification;
import ru.skillbox.notification.PushNotification;
import ru.skillbox.notification.SmsNotification;

public class Main {
    public static void main(String[] args) {

        EmailNotification email = new EmailNotification();
        email.setSubject("Успешная регистрация!");
        email.setEmailMessage("Спасибо за регистрацию на сервисе!");
        email.addReceiver("mail@mail.ru");
        System.out.println(email.toString());

        SmsNotification sms = new SmsNotification();
        sms.setSmsReceivers("+70001234567");
        sms.setSmsMessage("Спасибо за регистрацию на сервисе!");
        System.out.println(sms.toString());

        PushNotification push = new PushNotification();
        push.setPushTitle("Успешная регистрация!");
        push.setPushReceivers("o.yanovich");
        push.setPushMessage("Спасибо за регистрацию на сервисе!");

    }
}
