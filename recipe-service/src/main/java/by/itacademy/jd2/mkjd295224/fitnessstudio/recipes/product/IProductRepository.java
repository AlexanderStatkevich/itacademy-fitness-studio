package by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.product;

import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IProductRepository extends JpaRepository<Product, UUID> {
    Optional<Product> getByUuid(UUID uuid);
}
