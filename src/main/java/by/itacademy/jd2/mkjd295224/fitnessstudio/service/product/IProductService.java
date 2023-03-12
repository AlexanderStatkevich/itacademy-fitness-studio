package by.itacademy.jd2.mkjd295224.fitnessstudio.service.product;

import by.itacademy.jd2.mkjd295224.fitnessstudio.domain.Product;
import by.itacademy.jd2.mkjd295224.fitnessstudio.dto.product.ProductCreateDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.UUID;

public interface IProductService {

    void create(ProductCreateDto productCreateDto);

    Page<Product> findAll(Pageable pageable);

    void update(UUID uuid, LocalDateTime dtUpdate, ProductCreateDto productCreateDto);
}
