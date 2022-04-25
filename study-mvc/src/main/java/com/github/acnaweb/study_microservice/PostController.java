package com.github.acnaweb.study_microservice;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/posts")
public class PostController {

	private PostRepository postRepository;

	public PostController(PostRepository postRepository) {
		this.postRepository = postRepository;
	}
	// Retrieve
	@GetMapping
	public List<Post> listarPosts() {
		return postRepository.listarTodos();
	}

	// Retrieve
	@GetMapping("{id}")
	public Post pesquisarPorId(@PathVariable Long id) {
		return postRepository.pesquisarPorIdStream(id);
	}

	// Delete
	@DeleteMapping("{id}")
	public void apagarPost(@PathVariable Long id) {
		postRepository.apagarPorId(id);
	}

	// Create
	@PostMapping
	public Long criarPost(@RequestBody Post post) {
		return postRepository.adicionar(post);
	}

	// Update
	@PutMapping
	public Post atualizarPost(@RequestBody Post post) {
		return postRepository.atualizar(post);
	}

}
