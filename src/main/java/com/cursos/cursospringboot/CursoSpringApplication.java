package com.cursos.cursospringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cursos.cursospringboot.component.PostComponent;
import com.cursos.cursospringboot.model.Connection;
import com.cursos.cursospringboot.service.PostService;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class CursoSpringApplication implements CommandLineRunner {

	@Autowired
	@Qualifier("beanConnection")
	private Connection connection;

	@Autowired
	@Qualifier("postComponent")
	private PostComponent postComponent;

	
	public PostService postService;

	@Autowired
	public CursoSpringApplication(@Qualifier("postServiceDecorator1") PostService postService) {
		this.postService = postService;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(CursoSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		log.info(postService.validation(postComponent.getPosts()).toString());
	}

}
