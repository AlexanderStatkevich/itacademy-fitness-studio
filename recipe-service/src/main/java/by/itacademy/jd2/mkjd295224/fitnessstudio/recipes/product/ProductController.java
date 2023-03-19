package by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.product;


import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.domain.Product;
import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.mapper.ProductMapper;
import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.product.dto.ProductCreateDto;
import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.product.dto.ProductDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    private final ProductMapper mapper;

    public ProductController(ProductService productService, ProductMapper mapper) {
        this.productService = productService;
        this.mapper = mapper;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody ProductCreateDto productCreateDto) {
        productService.create(productCreateDto);
    }



    @GetMapping
    public Page<ProductDto> getPage(Pageable pageable) {
        Page<Product> productPage = productService.findAll(pageable);
        return productPage.map(mapper::toDto);
    }

    @PreAuthorize(value = "hasRole('ADMIN')")
    @PutMapping(path = "/{uuid}/dt_update/{dt_update}")
    public void update(@PathVariable("uuid") UUID uuid,
                       @PathVariable("dt_update") LocalDateTime dtUpdate,
                       @RequestBody ProductCreateDto productCreateDto) {
        productService.update(uuid, dtUpdate, productCreateDto);
    }
}
