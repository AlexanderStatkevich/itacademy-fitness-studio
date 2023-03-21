package by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.product;

import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.domain.Product;
import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.product.dto.ProductCreateUpdateDto;
import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.product.dto.mapper.ProductMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class ProductService implements IProductService {

    private final IProductRepository repository;

    private final ProductMapper mapper;

    public ProductService(IProductRepository repository, ProductMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void create(ProductCreateUpdateDto productCreateUpdateDto) {
        Product product = mapper.toEntity(productCreateUpdateDto);
        product.setUuid(UUID.randomUUID());
        repository.save(product);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Transactional
    @Override
    public void update(UUID uuid, LocalDateTime dateTimeUpdate, ProductCreateUpdateDto productCreateUpdateDto) {
        Product product = repository.getReferenceById(uuid);
        mapper.map(productCreateUpdateDto, product);
        product.setDateTimeUpdate(dateTimeUpdate);
        repository.save(product);
    }
}
