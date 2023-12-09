package com.ecommerce.backend.controller;

import com.ecommerce.backend.dtos.ProductDTO;
import com.ecommerce.backend.exceptions.ResourceNotFoundException;
import com.ecommerce.backend.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProduct(
            @PathVariable(name = "id") Integer id
    ){
        return productService.getProduct(id);
    }

    @GetMapping("/")
    public List<ProductDTO> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping("/")
    public ResponseEntity<?> createProduct(@Valid @RequestBody ProductDTO productDTO){
        return productService.saveProduct(productDTO);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") Integer productId)
            throws ResourceNotFoundException {
        productService.deleteProduct(productId);
        Map<String, Boolean> response=new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
