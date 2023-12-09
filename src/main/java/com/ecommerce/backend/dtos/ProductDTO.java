package com.ecommerce.backend.dtos;

import com.ecommerce.backend.model.Category;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Data
public class ProductDTO {
    private String name;
    private Double price;
    private String description;
    private Double discount;
    private Double mrp;
    private String unit;
    private Boolean out_of_stock;
}
