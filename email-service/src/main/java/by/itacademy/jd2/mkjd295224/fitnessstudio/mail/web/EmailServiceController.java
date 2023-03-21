package by.itacademy.jd2.mkjd295224.fitnessstudio.mail.web;

import by.itacademy.jd2.mkjd295224.fitnessstudio.mail.dto.EmailDto;
import by.itacademy.jd2.mkjd295224.fitnessstudio.mail.dto.EmailVerificationDto;
import by.itacademy.jd2.mkjd295224.fitnessstudio.mail.service.EmailService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/v1/mail")
public class EmailServiceController {

    private final EmailService service;

    public EmailServiceController(EmailService service) {
        this.service = service;
    }

    @PostMapping("/send")
    public void sendVerificationCode(@Valid @RequestBody EmailDto emailDto) {
        service.send(emailDto);
    }

    @GetMapping("/verify")
    public Boolean verifyEmail(@Valid EmailVerificationDto emailVerificationDto) {
        return service.verify(emailVerificationDto);
    }
}
