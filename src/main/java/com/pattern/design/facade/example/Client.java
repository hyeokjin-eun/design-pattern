package com.pattern.design.facade.example;

public class Client {

    public static void main(String[] args) {
        EmailSettings emailSettings = new EmailSettings();
        emailSettings.setHost("127.0.0.1");
        EmailSender emailSender = new EmailSender(emailSettings);
        EmailMessage emailMessage = new EmailMessage();
        emailMessage.setFrom("from@test.com");
        emailMessage.setTo("to@test.com");
        emailMessage.setSubject("subject");
        emailMessage.setText("text");
        emailSender.sendEmail(emailMessage);
    }
}
