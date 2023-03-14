package by.itacademy.jd2.mkjd295224.fitnessstudio.mail.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public record EmailVerificationDto(

        @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
        @NotBlank
        String email,
        @NotBlank
        String code
) {
}
