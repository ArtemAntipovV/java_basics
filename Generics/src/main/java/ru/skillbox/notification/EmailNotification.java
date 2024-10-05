package ru.skillbox.notification;

import java.util.ArrayList;
import java.util.List;

public class EmailNotification implements Notification{

    private  String  emailMessage;
    private String subject;
    private List<String> receivers;


    public void setEmailMessage(String emailMessage) {
        this.emailMessage = emailMessage;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public String getEmailMessage() {
        return emailMessage;
    }

    public void addReceiver(String receiver) {
        if (receivers == null) {
            receivers = new ArrayList<>();
        }
        receivers.add(receiver);
    }

    public List<String> getReceivers() {
        return receivers;
    }
    public String formattedMessage() {
        return "";
    }

    @Override
    public String toString() {
        return "EMAIL" + "\n" + "subject: " + getSubject()
                + "\n" + "receivers: " + getReceivers() + "\n"
                + "message: " + "<p>" + getEmailMessage() + "<p>";
    }
}











