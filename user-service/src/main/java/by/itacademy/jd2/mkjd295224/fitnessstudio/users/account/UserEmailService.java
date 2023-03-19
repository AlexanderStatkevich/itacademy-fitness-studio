package by.itacademy.jd2.mkjd295224.fitnessstudio.users.account;

import by.itacademy.jd2.mkjd295224.fitnessstudio.users.dto.EmailDto;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserEmailService {

    private final UserAccountClient userAccountClient;

    public UserEmailService(UserAccountClient userAccountClient) {
        this.userAccountClient = userAccountClient;
    }

    public void sendEmail(String email, String fullName) {
        Map<String, Object> model = Map.of("name", fullName, "host", "http://localhost:8080/api/v1/users");

        EmailDto emailDto = new EmailDto(email, model);
        userAccountClient.send(emailDto);
    }
}
