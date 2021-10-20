package com.cursos.cursospringboot.models;

import java.util.Date;

import lombok.Data;

@Data
public class Post {

	private int id;
	private String description;
	private String uriImg;
	private String title;
	private Date datePublished;
	
	public Post(int id, String description, String uriImg, String title, Date datePublished) {
		super();
		this.id = id;
		this.description = description;
		this.uriImg = uriImg;
		this.title = title;
		this.datePublished = datePublished;
	}

	
	
}
