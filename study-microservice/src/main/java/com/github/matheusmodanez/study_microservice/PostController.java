package com.github.matheusmodanez.study_microservice;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("posts")
public class PostController {

	private PostRepository postRepository = new PostRepository();
	
	// Create
	@PostMapping
	public Long createPost(Post post) {
		return postRepository.createPost(post);
	}

	// Retrieve/Repeat
	@GetMapping
	public List<Post> listPosts() {
		System.out.println("ListPosts()");
		return postRepository.listAll();
	}

	@GetMapping("{id}")
	public Post searchById(@PathVariable Long id) {
		System.out.println("SearchById()  -- Id: "+ id);
		return postRepository.searchById(id);
	}

	// Update
	@PutMapping
	public Post updatePost(Post post) {
		return postRepository.updatePost(post);
	}

	// Delete
	@DeleteMapping("{id}")
	public void deletePost(@PathVariable  Long id) {
		postRepository.deletePost(id);
	}

}
