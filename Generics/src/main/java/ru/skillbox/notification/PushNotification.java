package ru.skillbox.notification;

import lombok.*;

@Data
public class PushNotification implements Notification {
    private String pushMessage;
    private String pushReceivers;
    private String pushTitle;

    @Override
    public String formattedMessage() {
        return "";
    }

    @Override
    public String toString() {
        return "PUSH" + "\n" + "title: " + pushTitle + "\n"
                + "receiver: " + pushReceivers + "\n"
                + "message: " + "\ud83d\udc4b " + pushMessage;
    }
}
