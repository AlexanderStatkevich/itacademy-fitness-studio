package by.itacademy.jd2.mkjd295224.fitnessstudio.users.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = UserExistValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UserExist {

    String message() default "user doesn't exist";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
