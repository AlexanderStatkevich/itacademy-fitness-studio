package by.itacademy.jd2.mkjd295224.fitnessstudio.mail.service;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

import java.nio.charset.StandardCharsets;

@Service
public class EmailSendingService {

    private final JavaMailSender javaMailSender;

    public EmailSendingService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(String to, String subject, String text) {

        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            Context context = new Context();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
            mimeMessage.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));
            mimeMessage.setSubject(subject);
            mimeMessage.setContent(text, "text/html; charset=utf-8");
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
