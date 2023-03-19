package by.itacademy.jd2.mkjd295224.fitnessstudio.users.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record EmailVerificationDto(

        @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
        @NotBlank
        String mail,
        @NotBlank
        String code
) {
}
