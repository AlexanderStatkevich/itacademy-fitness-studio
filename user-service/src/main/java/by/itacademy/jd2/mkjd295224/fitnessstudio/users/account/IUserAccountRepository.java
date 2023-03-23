package by.itacademy.jd2.mkjd295224.fitnessstudio.users.account;

import by.itacademy.jd2.mkjd295224.fitnessstudio.users.domain.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IUserAccountRepository extends CrudRepository<User, UUID> {
    User findUserByEmail(String email);

    @Modifying
    @Query("update User u set status = by.itacademy.jd2.mkjd295224.fitnessstudio.users.domain.UserStatus.ACTIVATED where email = ?1")
    void activateUserByEmail(String email);
}
