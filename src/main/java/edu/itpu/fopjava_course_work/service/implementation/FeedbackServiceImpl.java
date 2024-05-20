package edu.itpu.fopjava_course_work.service.implementation;

import edu.itpu.fopjava_course_work.entity.Feedback;
import edu.itpu.fopjava_course_work.service.FeedbackService;
import edu.itpu.fopjava_course_work.utils.Colors;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FeedbackServiceImpl implements FeedbackService {

    private static final String SUBJECT = "Feedback about console application";

    @Override
    public void sendFeedback(Feedback feedback) throws MessagingException, IOException {
        // Read email credentials from configuration file
        Properties config = new Properties();
        FileInputStream configFile = new FileInputStream("src/main/resources/config.properties");
        config.load(configFile);
        String senderEmail = config.getProperty("email.username");
        String password = config.getProperty("email.password");

        // Recipient's email address
        String recipientEmail = config.getProperty("email.recipient");

        // Initialize mail properties
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp-mail.outlook.com");
        props.put("mail.smtp.port", "587");

        // Create a session with authentication
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, password);
            }
        });

        // Create a message
        Message mailMessage = new MimeMessage(session);
        mailMessage.setFrom(new InternetAddress(senderEmail));
        mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
        mailMessage.setSubject(SUBJECT);
        mailMessage.setText(feedback.toString());

        // Send the email
        Transport.send(mailMessage);

        System.out.println(Colors.GREEN + "Email sent successfully." + Colors.RESET);
    }
}