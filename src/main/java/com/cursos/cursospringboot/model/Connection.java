package com.cursos.cursospringboot.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class Connection {
	private String db;
	private String url;
}
