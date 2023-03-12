package by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.product;

import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.domain.Product;
import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.mapper.ProductMapper;
import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.product.dto.ProductCreateDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
    public void create(ProductCreateDto productCreateDto) {
        Product product = mapper.toEntity(productCreateDto);
        repository.save(product);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void update(UUID uuid, LocalDateTime dateTimeUpdate, ProductCreateDto productCreateDto) {
        Product product = repository.getReferenceById(uuid);
        mapper.map(productCreateDto, product);
        product.setDateTimeUpdate(dateTimeUpdate);
        repository.save(product);
    }
}
