package by.itacademy.jd2.mkjd295224.fitnessstudio.users.validation;

import by.itacademy.jd2.mkjd295224.fitnessstudio.users.manage.UserManageService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class EntityExistValidator implements ConstraintValidator<UniqueEntity, String> {

    private final UserManageService userManageService;

    public EntityExistValidator(UserManageService userManageService) {
        this.userManageService = userManageService;
    }

    @Override
    public void initialize(UniqueEntity contactNumber) {
    }

    @Override
    public boolean isValid(String contactField, ConstraintValidatorContext cxt) {
        return userManageService.notExistsByEmail(contactField);
    }
}
