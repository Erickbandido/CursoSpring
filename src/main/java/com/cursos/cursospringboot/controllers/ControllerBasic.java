package com.cursos.cursospringboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hola")
public class ControllerBasic {

	@GetMapping("/saludar")
	public String saludar() {
		return "index";
	}
}
