package by.itacademy.jd2.mkjd295224.fitnessstudio.mapper;

import by.itacademy.jd2.mkjd295224.fitnessstudio.domain.Product;
import by.itacademy.jd2.mkjd295224.fitnessstudio.dto.product.ProductCreateDto;
import by.itacademy.jd2.mkjd295224.fitnessstudio.dto.product.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface ProductMapper {

    Product toEntity(ProductCreateDto source);

    ProductDto toDto(Product source);

    void map(ProductCreateDto source, @MappingTarget Product target);
}
