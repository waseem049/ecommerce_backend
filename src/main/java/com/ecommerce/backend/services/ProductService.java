package com.ecommerce.backend.services;

import com.ecommerce.backend.dtos.ProductDTO;
import com.ecommerce.backend.exceptions.ResourceNotFoundException;
import com.ecommerce.backend.mappers.ProductMapper;
import com.ecommerce.backend.model.Product;
import com.ecommerce.backend.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;
    @Autowired
    ProductMapper productMapper;

    public ResponseEntity<ProductDTO> getProduct(
            Integer id
    ) throws ResourceNotFoundException {

        Product product = productRepo.findById(id)
                .orElseThrow(()->
                        new ResourceNotFoundException("Product not found for this Id :: " + id));
        ProductDTO productDTO = productMapper.toDTO(product);

        return ResponseEntity.ok().body(productDTO);
    }

    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepo.findAll();

        return (List<ProductDTO>) products.stream().map(product -> {
            return productMapper.toDTO(product);
        });
    }

    public ResponseEntity<?> saveProduct(ProductDTO productDTO) {
        Product product = productMapper.toEntity(productDTO);
        productRepo.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body("Product created successfully");
    }


    public void deleteProduct(Integer productId) {
        productRepo.deleteById(productId);
    }
}
