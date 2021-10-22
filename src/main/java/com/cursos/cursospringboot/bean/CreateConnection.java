package com.cursos.cursospringboot.bean;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import com.cursos.cursospringboot.model.Connection;
import com.cursos.cursospringboot.model.User;

@Component
public class CreateConnection {
	@Bean(name = "beanUsuario")
	public User getUser() {
		return new User();

	}
	
	@Bean(name="beanConnection")
	public Connection getConnection() {
		Connection connection = new Connection();
		connection.setDb("mysql");
		connection.setUrl("localhost");
		return connection;
	}
	
	@Bean(name="beanDataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(" com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/blog");
		dataSource.setUsername("root");
		dataSource.setPassword("ErickOrtega9!");
		return dataSource;
	}
}
