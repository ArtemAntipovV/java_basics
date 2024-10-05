package ru.skillbox.notification;

public class PushNotification implements Notification {

    private String pushMessage;
    private String pushReceivers;
    private String pushTitle;


    public PushNotification(String pushMessage, String pushReceivers, String pushTitle) {
        this.pushMessage = pushMessage;
        this.pushReceivers = pushReceivers;
        this.pushTitle = pushTitle;
    }

    public PushNotification() {

    }

    public String getPushMessage() {
        return pushMessage;
    }

    public void setPushMessage(String pushMessage) {
        this.pushMessage = pushMessage;
    }

    public String getPushReceivers() {
        return pushReceivers;
    }

    public void setPushReceivers(String pushReceivers) {
        this.pushReceivers = pushReceivers;
    }

    public String getPushTitle() {
        return pushTitle;
    }

    public void setPushTitle(String pushTitle) {
        this.pushTitle = pushTitle;
    }

    @Override
    public String formattedMessage() {
        return "";
    }

    @Override
    public String toString() {
        return "PUSH" + "\n" + "title: " + pushTitle + "\n"
                + "receiver: " + pushReceivers + "\n"
                + "message: " + "\ud83d\udc4b" + pushMessage;
    }
}
