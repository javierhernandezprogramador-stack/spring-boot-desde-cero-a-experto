package com.davinchicoder.spring_boot_web_cero_a_experto.product.infrastructure.api.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

@Data
public class CreateProductDto {

    private Long id;
    @NotBlank //Esta validación no permite valores en blanco
    private String name;
    @Length(min = 10, max = 255, message = "Description must be between 10 and 255 characters")
    //validación que permite definir la longitud
    private String description;
    @DecimalMin(value = "0.01", inclusive = false)//validación que permite un precio minimo
    @DecimalMax(value = "999.99", inclusive = false)
    private Double price;
    private MultipartFile file;

}
