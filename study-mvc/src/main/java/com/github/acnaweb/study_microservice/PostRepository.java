package com.github.acnaweb.study_microservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PostRepository {
	private List<Post> posts;
	private long currentPost = 3;

	public PostRepository() {
		this.load();
	}

	private void load() {
		posts = new ArrayList<Post>();

		Post post = new Post();
		post.setId(1L);
		post.setTitle("Título 1");
		post.setAuthor("AC");

		posts.add(post);

		post = new Post();
		post.setId(3L);
		post.setTitle("Título 3");
		post.setAuthor("Pelé");

		posts.add(post);
	}

	public List<Post> listarTodos() {
		return posts;
	}

	public Post pesquisarPorId(Long id) {
		for (Post post : posts) {
			if (post.getId().equals(id)) {
				return post;
			}
		}
		return null;
	}

	public Post pesquisarPorIdStream(Long id) {
		return posts.stream().filter(item -> item.getId().equals(id)).findFirst().orElse(null);
	}

	public void apagarPorId(Long id) {
		posts.removeIf(item -> item.getId().equals(id));
	}

	public Post atualizar(Post post) {
		for (Post postAtual : posts) {
			if (postAtual.getId().equals(post.getId())) {
				postAtual.setTitle(post.getTitle());
				postAtual.setAuthor(post.getAuthor());

				return postAtual;
			}
		}
		return null;
	}

	public Long adicionar(Post post) {
		currentPost++;
		post.setId(currentPost);
		posts.add(post);
		return post.getId();
	}
}
