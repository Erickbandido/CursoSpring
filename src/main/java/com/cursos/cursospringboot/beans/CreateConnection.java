package com.cursos.cursospringboot.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.cursos.cursospringboot.models.Connection;

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
