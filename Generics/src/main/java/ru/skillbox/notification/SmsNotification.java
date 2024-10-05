package ru.skillbox.notification;

import java.util.List;

public class SmsNotification implements Notification{

    private  String  smsMessage;
    private String smsReceivers;

    public SmsNotification(String smsMessage) {
        this.smsMessage = smsMessage;
    }

    public SmsNotification() {

    }

    public String getSmsMessage() {
        return smsMessage;
    }

    public String getSmsReceivers() {
        return smsReceivers;
    }

    public void setSmsMessage(String smsMessage) {
        this.smsMessage = smsMessage;
    }

    public void setSmsReceivers(String smsReceivers) {
        this.smsReceivers = smsReceivers;
    }

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
