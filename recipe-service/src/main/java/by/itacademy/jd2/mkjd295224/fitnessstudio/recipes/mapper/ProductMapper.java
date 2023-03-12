package by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.mapper;

import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.domain.Product;
import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.product.dto.ProductCreateDto;
import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.product.dto.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface ProductMapper {

    Product toEntity(ProductCreateDto source);

    ProductDto toDto(Product source);

    void map(ProductCreateDto source, @MappingTarget Product target);
}
