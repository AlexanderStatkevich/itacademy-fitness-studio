package by.itacademy.jd2.mkjd295224.fitnessstudio.users.account.mailing;

import by.itacademy.jd2.mkjd295224.fitnessstudio.users.domain.User;

public record UserRegisteredEvent(
        String email,
        String fullName
) {
    public UserRegisteredEvent(User user) {
        this(user.getEmail(), user.getFullName());
    }
}
