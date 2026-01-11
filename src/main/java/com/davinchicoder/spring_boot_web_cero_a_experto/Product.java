package com.davinchicoder.spring_boot_web_cero_a_experto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Product {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String image;
}
