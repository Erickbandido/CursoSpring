package com.cursos.cursospringboot.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cursos.cursospringboot.model.Post;
import com.cursos.cursospringboot.service.PostService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PostServiceImplementation implements PostService{

	@Override
	public List<Post> validationId(List<Post> posts){
		for (Post post : posts) {
			if(post.getId()==0) {
				log.warn("Empty ID!!!");
			}
		}
		return posts;
	}
	
}
