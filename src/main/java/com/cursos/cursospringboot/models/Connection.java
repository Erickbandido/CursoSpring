package com.cursos.cursospringboot.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class Connection {
	private String db;
	private String url;
}
