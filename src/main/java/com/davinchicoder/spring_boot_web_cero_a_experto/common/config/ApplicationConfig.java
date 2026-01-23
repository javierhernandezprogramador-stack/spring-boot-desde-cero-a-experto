package com.davinchicoder.spring_boot_web_cero_a_experto.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableAsync //para habilitar la asincronización en el proyecto
@EnableScheduling
public class ApplicationConfig {
    //clase de configuraciones para no hacerlo en el main, aunque se puede en el main pero
    //esta es la mejor practica
}
