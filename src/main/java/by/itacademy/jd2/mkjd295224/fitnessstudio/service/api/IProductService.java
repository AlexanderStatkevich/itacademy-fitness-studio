package by.itacademy.jd2.mkjd295224.fitnessstudio.service.api;

import by.itacademy.jd2.mkjd295224.fitnessstudio.dto.product.ProductDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface IProductService {

    void create(ProductDto productDto);

    List<ProductDto> findAll();

    void update(UUID uuid, LocalDateTime dtUpdate, ProductDto productDto);
}
