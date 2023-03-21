package by.itacademy.jd2.mkjd295224.fitnessstudio.users.account.mailing.dto;

import java.util.Map;

public record EmailDto(
        String email,
        Map<String, Object> model
) {
}
