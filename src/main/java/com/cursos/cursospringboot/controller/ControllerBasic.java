package com.cursos.cursospringboot.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cursos.cursospringboot.component.PostComponent;
import com.cursos.cursospringboot.configuration.Pages;
import com.cursos.cursospringboot.model.Connection;
import com.cursos.cursospringboot.model.Post;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/home")
public class ControllerBasic {

	@Autowired
	@Qualifier("postComponent")
	private PostComponent postComponent;

	@GetMapping(path = { "/post", "/" })
	public String saludar(Model model) {
		model.addAttribute("posts", this.postComponent.getPosts());
		return "index";
	}

	@GetMapping(path = "/public")
	public ModelAndView post() {
		ModelAndView modelView = new ModelAndView(Pages.HOME);
		modelView.addObject("posts", this.postComponent.getPosts());
		return modelView;
	}

	@GetMapping(path = { "/postbyid", "/post/{id}" })
	public ModelAndView getIndividualPost(@PathVariable(name = "id") int id) {

		ModelAndView modelView = new ModelAndView(Pages.POST);
		List<Post> postFiltered = this.postComponent.getPosts().stream().filter((p) -> {
			return p.getId() == id;
		}).collect(Collectors.toList());
		modelView.addObject("post", postFiltered.get(0));
		return modelView;
	}

	@GetMapping(path = "/newpost")
	public ModelAndView getForm() {
		ModelAndView mv = new ModelAndView("form", "post", new Post());
		return mv;
	}

	@PostMapping(path = "/addnewpost")
	public String addNewPost(Post post, Model model) {
		log.info(post.toString());
		List<Post> postList = this.postComponent.getPosts();
		postList.add(post);
		model.addAttribute("posts", postList);
		return "index";
	}
}
