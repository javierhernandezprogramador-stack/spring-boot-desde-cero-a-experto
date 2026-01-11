package com.davinchicoder.spring_boot_web_cero_a_experto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    public List<Product> products;

    public ProductController() {
        this.products = new ArrayList<>();

        products.add(Product.builder().id(1L).name("Product 1").description("Descripcion 1").price(100.0).image("55455ss").build());
        products.add(Product.builder().id(2L).name("Product 2").description("Descripcion 2").price(250.0).image("4545ss").build());
        products.add(Product.builder().id(3L).name("Product 3").description("Descripcion 3").price(300.0).image("sdff88").build());
    }

    /*
     * El @RequestParam sirve para agregar mas parametros a la consulta
     */
    @GetMapping("")
    public ResponseEntity<List<Product>> getAllProducts(@RequestParam(required = false
    ) String pageSize) {
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> productOptional = products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();

        if (!productOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(productOptional.get());
    }

    @PostMapping
    public ResponseEntity<Void> saveProduct(@RequestBody Product product) {
        products.add(product);
        return ResponseEntity.created(URI.create("/api/v1/products/".concat(product.getId().toString()))).build();
    }

    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        Product productSelect = products.stream()
                .filter(p -> p.getId().equals(product.getId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found"));

        productSelect.setDescription(product.getDescription());
        productSelect.setName(product.getName());
        productSelect.setPrice(product.getPrice());
        productSelect.setImage(product.getName());

        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        products.removeIf(p -> p.getId().equals(id));
        return ResponseEntity.noContent().build();
    }
}
