package com.cursos.cursospringboot.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.cursos.cursospringboot.model.Connection;

@Component
public class CreateConnection {
	@Bean(name="beanConnection")
	public Connection getConnection() {
		Connection connection = new Connection();
		connection.setDb("mysql");
		connection.setUrl("localhost");
		return connection;
	}
}
