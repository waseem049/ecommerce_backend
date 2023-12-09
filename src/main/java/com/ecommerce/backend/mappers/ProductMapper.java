package com.ecommerce.backend.mappers;

import com.ecommerce.backend.dtos.ProductDTO;
import com.ecommerce.backend.model.Product;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
public class ProductMapper {
    public Product toEntity(ProductDTO productDTO){
        Product product=new Product();
        product.setName(productDTO.getName());
        product.setMrp(productDTO.getMrp());
        product.setDescription(productDTO.getDescription());
        product.setUnit(productDTO.getUnit());
        product.setPrice(productDTO.getPrice());
        product.setDiscount(productDTO.getDiscount());
        product.setOut_of_stock(productDTO.getOut_of_stock());

        return product;
    }

    public ProductDTO toDTO(Product product){
        ProductDTO productDTO=new ProductDTO();

        productDTO.setName(product.getName());
        productDTO.setMrp(product.getMrp());
        productDTO.setDescription(product.getDescription());
        productDTO.setUnit(product.getUnit());
        productDTO.setPrice(product.getPrice());
        productDTO.setDiscount(product.getDiscount());
        productDTO.setOut_of_stock(product.getOut_of_stock());

        return productDTO;
    }

//    public ProductDTO getProductDtoById(Integer id){
//        ProductDTO productDTO=
//    }
}
