package by.itacademy.jd2.mkjd295224.fitnessstudio.repository;

import by.itacademy.jd2.mkjd295224.fitnessstudio.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IUserManageRepository extends JpaRepository<User, UUID>, PagingAndSortingRepository<User, UUID> {
}
