package com.ecommerce.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pr_id;

    @Column
    private String name;
    @Column
    private Double price;
    @Column
    private String description;
    @Column
    private Double discount;
    @Column
    private Double mrp;
    @Column
    private String unit;

    // Many-to-one relationship with Category
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cat_id")
    private Category category_id;

    @Column
    private Boolean out_of_stock;
}
