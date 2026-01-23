package com.davinchicoder.spring_boot_web_cero_a_experto.product.application.command.delete;

import com.davinchicoder.spring_boot_web_cero_a_experto.common.mediator.RequestHandler;
import com.davinchicoder.spring_boot_web_cero_a_experto.product.domain.port.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteProductHandler implements RequestHandler<DeleteProductRequest, Void> {

    private final ProductRepository productRepository;

    @Override
    public Void handle(DeleteProductRequest request) {

        System.out.println("Eliminado producto con id: " + request.getId() + " ....");

        try {
            Thread.sleep(5000);//hacemos que tarde 5 segundos en procesarce
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        productRepository.deleteById(request.getId());

        System.out.println("Proucto eliminado con id: " + request.getId() + " ....");

        return null;
    }

    @Override
    public Class<DeleteProductRequest> getRequestType() {
        return DeleteProductRequest.class;
    }
}
