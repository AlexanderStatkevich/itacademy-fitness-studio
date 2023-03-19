package by.itacademy.jd2.mkjd295224.fitnessstudio.users.account;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class UserAccountEventListener {

    private final UserEmailService emailService;

    public UserAccountEventListener(UserEmailService emailService) {
        this.emailService = emailService;
    }

    @Async
    @EventListener
    public void onUserCreation(UserRegisteredEvent event) {
        String email = event.email();
        String fullName = event.fullName();
        emailService.sendEmail(email, fullName);
    }
}
