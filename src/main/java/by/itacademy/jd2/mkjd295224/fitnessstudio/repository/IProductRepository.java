package by.itacademy.jd2.mkjd295224.fitnessstudio.repository;

import by.itacademy.jd2.mkjd295224.fitnessstudio.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IProductRepository extends JpaRepository<Product, UUID> {
}
