package com.example.medic;

import android.os.AsyncTask;

import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class mail extends AsyncTask<String, Void, Void> {

    @Override
    protected Void doInBackground(String... strings) {
        final String username = "dospoker";
        final String password = "типа пароль";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.yandex.ru");
        prop.put("mail.transport.protocol", "smtps");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.user", "dospoker");
        prop.put("mail.smtp.ssl.enable", "true"); //TLS
        prop.put("mail.debug", "true");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("dospoker@yandex.ru"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("helvixer@gmail.com")
            );
            message.setSubject("Проверочный код для Medic");
            Random rand = new Random();
            int code = rand.nextInt(8000) + 1000;
            message.setText("Ваш код проверки: "+ code);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
