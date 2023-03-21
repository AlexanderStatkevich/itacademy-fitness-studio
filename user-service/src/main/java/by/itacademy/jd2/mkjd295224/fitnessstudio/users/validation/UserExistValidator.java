package by.itacademy.jd2.mkjd295224.fitnessstudio.users.validation;

import by.itacademy.jd2.mkjd295224.fitnessstudio.users.manage.UserManageService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class UserExistValidator implements ConstraintValidator<UserExist, String> {

    private final UserManageService userManageService;

    public UserExistValidator(UserManageService userManageService) {
        this.userManageService = userManageService;
    }

    @Override
    public void initialize(UserExist contactNumber) {
    }

    @Override
    public boolean isValid(String contactField, ConstraintValidatorContext cxt) {
        return !userManageService.notExistsByEmail(contactField);
    }
}
