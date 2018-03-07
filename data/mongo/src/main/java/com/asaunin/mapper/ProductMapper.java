package com.asaunin.mapper;

import com.asaunin.domain.Product;
import com.asaunin.model.ProductForm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ObjectIdMapper.class)
public interface ProductMapper {

    @Mapping(source = "_id", target = "id")
    ProductForm formDomainToModel(Product product);

    @Mapping(source = "id", target = "_id")
    Product fromModelToDomain(ProductForm product);

}
