package com.cursos.cursospringboot.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cursos.cursospringboot.model.Post;
import com.cursos.cursospringboot.service.PostService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PostServiceImp2 implements PostService{

	@Override
	public List<Post> validation(List<Post> posts){
		for (Post post : posts) {
			if(post.getTitle()=="") {
				log.warn("Empty Title!!!");
			}
		}
		return posts;
	}
}
