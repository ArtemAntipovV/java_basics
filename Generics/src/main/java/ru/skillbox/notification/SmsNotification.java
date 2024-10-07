package ru.skillbox.notification;

import lombok.Data;

import java.util.List;

@Data
public class SmsNotification implements Notification{
    private  String  smsMessage;
    private String smsReceivers;

    @Override
    public String formattedMessage() {
        return "";
    }

    @Override
    public String toString() {
        return "SMS" + "\n" + "receivers: " + smsReceivers + "\n"
                + "message: " + smsMessage;
    }


}
