package br.com.gustavoakira.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gustavoakira.blog.models.Post;
import br.com.gustavoakira.blog.service.PostService;

@RestController
@RequestMapping("/api/v1")
public class PostController {
	@Autowired
	private PostService service;
	
	@PostMapping("post")
	public ResponseEntity<Post> createPost(@RequestBody Post post) throws Exception{
		return ResponseEntity.status(HttpStatus.CREATED).body(service.createPost(post));
	}
	
	@GetMapping("posts")
	public ResponseEntity<List<Post>> getPosts(){
		return ResponseEntity.ok(service.getPosts());
	}
	@DeleteMapping("post/{id}")
	public ResponseEntity<String> deletePost(@PathVariable("id") String id){
		service.removePost(id);
		return ResponseEntity.noContent().build();
	}
	@GetMapping("post/{id}")
	public ResponseEntity<Post> getPost(@PathVariable("id") String id){
		return ResponseEntity.ok(service.getOne(id));
	}
}
