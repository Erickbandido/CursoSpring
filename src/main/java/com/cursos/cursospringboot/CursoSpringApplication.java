package com.cursos.cursospringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cursos.cursospringboot.models.Connection;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class CursoSpringApplication implements CommandLineRunner{

	@Autowired
	@Qualifier("beanConnection")
	private Connection connection;
	
	public static void main(String[] args) {
		SpringApplication.run(CursoSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		log.info(connection.getDb());
		
	}

}
