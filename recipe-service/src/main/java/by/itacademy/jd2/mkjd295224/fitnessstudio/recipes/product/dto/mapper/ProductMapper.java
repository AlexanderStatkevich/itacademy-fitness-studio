package by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.product.dto.mapper;

import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.domain.Product;
import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.product.dto.ProductCreateUpdateDto;
import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.product.dto.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface ProductMapper {

    Product toEntity(ProductCreateUpdateDto source);

    ProductDto toDto(Product source);

    void map(ProductCreateUpdateDto source, @MappingTarget Product target);
}
