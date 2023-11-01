package com.mentoria.mentoriaprogramacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class MentoriaprogramacaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MentoriaprogramacaoApplication.class, args);
	}

}
