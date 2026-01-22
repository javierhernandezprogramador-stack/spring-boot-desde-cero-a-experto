package com.davinchicoder.spring_boot_web_cero_a_experto.product.application.command.create;

import com.davinchicoder.spring_boot_web_cero_a_experto.common.mediator.Request;
import lombok.Builder;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Builder

//Es de tipo void ya que no devulve contenido la respuesta
public class CreateProductRequest implements Request<Void> {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private MultipartFile file;
}
