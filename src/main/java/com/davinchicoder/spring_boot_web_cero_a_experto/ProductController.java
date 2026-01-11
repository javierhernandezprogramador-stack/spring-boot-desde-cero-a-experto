package com.davinchicoder.spring_boot_web_cero_a_experto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    public List<Product> products;

    public ProductController() {
        this.products = List.of(
                Product.builder().id(1L).name("Product 1").description("Descripcion 1").price(100.0).image("55455ss").build(),
                Product.builder().id(2L).name("Product 2").description("Descripcion 2").price(250.0).image("4545ss").build(),
                Product.builder().id(3L).name("Product 3").description("Descripcion 3").price(300.0).image("sdff88").build()
        );
    }

    /*
     * El @RequestParam sirve para agregar mas parametros a la consulta
     */
    @GetMapping("")
    public ResponseEntity<List<Product>> getAllProducts(@RequestParam String pageSize) {
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public String getProductById(@PathVariable Long id) {
        return "Product Controller ".concat(id.toString());
    }
}
