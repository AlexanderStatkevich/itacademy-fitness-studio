package by.itacademy.jd2.mkjd295224.fitnessstudio.repository;

import by.itacademy.jd2.mkjd295224.fitnessstudio.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface IUserManageRepository extends PagingAndSortingRepository<User, UUID> {

}
