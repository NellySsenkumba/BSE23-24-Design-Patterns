package sendMail;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class SendEmail {
    public static void sendMail() {

        // Set mail properties
        Properties properties = new Properties();
        // properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.host", "mail.mak.ac.ug");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Create a new session with an authenticator
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("nelson.ssenkumba@students.mak.ac.ug", "P@ss1234");
            }
        });

        try {
            // Create a new message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("nelson.ssenkumba@students.mak.ac.ug"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("ssenkumbanelson.sn@gmail.com"));
            message.setSubject("Test email");
            message.setText("Hello from Java!");

            // Send the message
            Transport.send(message);

            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
