package com.davinchicoder.spring_boot_web_cero_a_experto.product.application.scheduling;

import com.davinchicoder.spring_boot_web_cero_a_experto.product.domain.port.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j //permite la generación de log
public class FixProductsPriceSchedule {

    private final ProductRepository productRepository;

    @Scheduled(fixedRate = 5000) //cada cuando va ocurrir
    public void fixProductsPrice() {
        log.info("Fixing Products Price");

        productRepository.findAll().forEach(product -> {
            product.setPrice(product.getPrice() * 1.1);
            productRepository.upsert(product);
        });

        log.info("Finished fixing products price");
    }
}
