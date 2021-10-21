package com.cursos.cursospringboot.components;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cursos.cursospringboot.models.Post;

@Component("postComponent")
public class PostComponent {
	
	public List<Post> getPosts() {
		ArrayList<Post> postList = new ArrayList<>();
		postList.add(
				new Post(1, "Lorem ipsum dolor sit amet", "/img/libro_viejo_abierto.jpg", "Titulo genial", new Date()));
		postList.add(
				new Post(2, "Lorem ", "/img/libro_viejo_abierto.jpg", "Titulo genial 2: Electro Boogaloo", new Date()));
		return postList;
	}

}
