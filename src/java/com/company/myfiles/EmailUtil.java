package com.company.myfiles;

import java.util.Properties;
import jakarta.mail.*;
import jakarta.mail.internet.*;

public class EmailUtil {

    public static void sendOTP(String toEmail, String otp) {

        final String fromEmail = "sandysam7224@gmail.com";
        final String password = "ajfypsvdtuvmysjs";

        Properties props = new Properties();
        
props.put("mail.smtp.host", "smtp.gmail.com");
props.put("mail.smtp.port", "587");
props.put("mail.smtp.auth", "true");
props.put("mail.smtp.starttls.enable", "true");
props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        Session session = Session.getInstance(props,
            new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            });

       try {
    System.out.println("Inside EmailUtil...");
    System.out.println("Sending to: " + toEmail);

    Message message = new MimeMessage(session);
    message.setFrom(new InternetAddress(fromEmail));
    message.setRecipients(Message.RecipientType.TO,
            InternetAddress.parse(toEmail));
    message.setSubject("OTP Verification");

    message.setText("Your OTP is: " + otp);

    System.out.println("Before Transport.send()");

    Transport.send(message);

    System.out.println("After Transport.send() SUCCESS");

} catch (Exception e) {
    System.out.println("EMAIL ERROR:");
    e.printStackTrace();
}
    }
}