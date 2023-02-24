package by.itacademy.jd2.mkjd295224.fitnessstudio.repository;

import by.itacademy.jd2.mkjd295224.fitnessstudio.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IUserAccountRepository extends CrudRepository<User, UUID> {

}
