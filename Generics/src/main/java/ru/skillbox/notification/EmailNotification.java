package ru.skillbox.notification;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class EmailNotification implements Notification{
    private  String  emailMessage;
    private String subject;
    private List<String> receivers;

    public void addReceiver(String receiver) {
        if (receivers == null) {
            receivers = new ArrayList<>();
        }
        receivers.add(receiver);
    }

    public String formattedMessage() {
        return "";
    }

    @Override
    public String toString() {
        return "EMAIL" + "\n" + "subject: " + getSubject()
                + "\n" + "receivers: " + getReceivers().stream().collect(Collectors.joining(", ")) + "\n"
                + "message: " + "<p>" + getEmailMessage() + "<p>";
    }
}











