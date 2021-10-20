package com.cursos.cursospringboot.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cursos.cursospringboot.models.Post;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/home")
public class ControllerBasic {

	public List<Post>getPosts(){
		ArrayList<Post> postList = new ArrayList<>();
		postList.add(
				 new Post(
						  1,
						  "Lorem ipsum dolor sit amet",
						  "/img/libro_viejo_abierto.jpg",
						  "Titulo genial",
						  new Date()
				 )
		);
		return postList;
	}
	
	@GetMapping(path={"/post","/"})
	public String saludar(Model model) {
		model.addAttribute("posts", this.getPosts() );
		return "index";
	}
}
