package ru.skillbox.notification_sender;

import ru.skillbox.notification.Notification;

import java.util.List;

public class PushNotificationSender implements NotificationSender {
    @Override
    public void send(Notification notification) {
        notification.formattedMessage();
    }

    @Override
    public void send(List notifications) {
        for (Object notification : notifications) {
            send((List) notification);
        }
    }
}
