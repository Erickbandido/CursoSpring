package com.cursos.cursospringboot.models;


import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Post implements Serializable {

	private int id;
	private String description;
	private String uriImg = "http://localhost:8080/img/libro_viejo_abierto.jpg";
	private String title;
	private Date datePublished = new Date();
	
	public Post(int id, String description, String uriImg, String title, Date datePublished) {
		super();
		this.id = id;
		this.description = description;
		this.uriImg = uriImg;
		this.title = title;
		this.datePublished = datePublished;
	}
	
	
}
