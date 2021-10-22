package com.cursos.cursospringboot;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cursos.cursospringboot.component.PostComponent;
import com.cursos.cursospringboot.model.Connection;
import com.cursos.cursospringboot.service.PostService;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class CursoSpringApplication implements CommandLineRunner {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
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
		//jdbcTemplate.execute("insert into blog.permiso (nombre) values (\"Ejemplo\")");
		Path path = Paths.get("src/main/resources/import.sql");
		
		log.info(path.toString());
		
		try {
			BufferedReader br = Files.newBufferedReader(path, Charset.forName("UTF-8"));
			String line;
			while ((line =br.readLine()) !=null ) {
				log.info(line);
				
			}
		} catch(IOException exception) {
			
		}
	}

}
