package by.itacademy.jd2.mkjd295224.fitnessstudio.mail.service;

import by.itacademy.jd2.mkjd295224.fitnessstudio.mail.dao.EmailDao;
import by.itacademy.jd2.mkjd295224.fitnessstudio.mail.dto.EmailDto;
import by.itacademy.jd2.mkjd295224.fitnessstudio.mail.dto.EmailVerificationDto;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class EmailService {

    public static final String SUBJECT = "Email verification";
    public static final String VERIFICATION_CODE_MODEL_KEY = "code";
    private final EmailSendingService emailSendingService;
    private final TemplateProcessService templateProcessService;

    private final EmailDao emailDao;

    public EmailService(EmailSendingService emailSendingService, TemplateProcessService templateProcessService, EmailDao emailDao) {
        this.emailSendingService = emailSendingService;
        this.templateProcessService = templateProcessService;
        this.emailDao = emailDao;
    }

    public void send(EmailDto emailDto) {
        String email = emailDto.email();
        String verificationCode = CodeGenerationUtil.generateCode();
        emailDao.save(email, verificationCode);

        Map<String, Object> model = emailDto.model();
        model.put(VERIFICATION_CODE_MODEL_KEY, verificationCode);
        String html = templateProcessService.fillTemplate(model);
        emailSendingService.sendEmail(email, SUBJECT, html);
    }

    public boolean verify(EmailVerificationDto emailVerificationDto) {
        String email = emailVerificationDto.email();
        String code = emailVerificationDto.code();
        return emailDao.existsByEmailAndCode(email, code);
    }
}
