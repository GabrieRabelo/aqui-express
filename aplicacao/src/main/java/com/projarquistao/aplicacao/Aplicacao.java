package com.projarquistao.aplicacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.projarquistao" })
@EntityScan(basePackages = { "com.projarquistao" })
public class Aplicacao {
	public static void main(String[] args) {
		SpringApplication.run(Aplicacao.class, args);
	}

}
