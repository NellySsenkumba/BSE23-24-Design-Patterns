package org.sendMail;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class SendEmail {
    public static void sendMail(String email, String msg) {

        // Set mail properties
        Properties properties = new Properties();

        FileInputStream input;
        try {
            input = new FileInputStream("config.properties");
            try {
                properties.load(input);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Create a new session with an authenticator
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(properties.get("username").toString(),
                        new String(Base64.getDecoder().decode(properties.getProperty("password"))));
            }
        });

        try {
            // Create a new message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(properties.get("username").toString()));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("Notification from BSE23-24 POS system");
            message.setText(msg);

            // Send the message
            // Transport.send(message);

            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
