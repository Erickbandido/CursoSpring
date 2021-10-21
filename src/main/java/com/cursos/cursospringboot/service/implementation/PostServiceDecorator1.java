package com.cursos.cursospringboot.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursos.cursospringboot.model.Post;
import com.cursos.cursospringboot.service.PostService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("postServiceDecorator1")
public class PostServiceDecorator1 implements PostService{

	@Autowired
	private PostServiceImplementation postImp1;
	
	@Autowired
	private PostServiceImp2 postImp2;

	@Override
	public List<Post> validation(List<Post> postsList) {
		log.info("primera Implementacion");
		postsList.addAll(postImp1.validation(postsList));
		log.info("segunda Implementacion");
		postsList.addAll(postImp2.validation(postsList));
		
		return postsList;
	}
	

	
}
