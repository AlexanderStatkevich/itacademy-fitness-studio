package by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.product;

import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.domain.Product;
import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.product.dto.ProductCreateUpdateDto;
import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.product.dto.mapper.ProductMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.OptimisticLockException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Service
public class ProductService implements IProductService {

    public static final int ZONE_OFFSET = 3;
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
        Product product = repository.getByUuid(uuid)
                .orElseThrow(() -> new EntityNotFoundException("product not found"));
        if (!product.getDateTimeUpdate().truncatedTo(ChronoUnit.MILLIS).equals(dateTimeUpdate.minusHours(ZONE_OFFSET))) {
            throw new OptimisticLockException("product with " + uuid + " has been modified");
        }
        mapper.map(productCreateUpdateDto, product);
        product.setDateTimeUpdate(dateTimeUpdate);
        repository.save(product);
    }
}
