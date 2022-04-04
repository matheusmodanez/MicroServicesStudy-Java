package com.github.matheusmodanez.study_microservice;

import java.util.ArrayList;
import java.util.List;

public class PostRepository {
	private List<Post> posts;
	private long currentId = 3;
	
	public PostRepository() {
		this.load();
	}
	
	private void load() {
		posts = new ArrayList<Post>();
		
		Post post = new Post();
		post.setId(1L);
		post.setTitle("Titulo 1");
		post.setAuthor("Matheus");
		
		posts.add(post);
		
		post = new Post();
		post.setId(2L);
		post.setTitle("Titulo 2");
		post.setAuthor("Matheus Nathan");
		
		posts.add(post);
	}
	
	public List<Post> listAll(){
		return posts;
	}

	public Post searchById(Long id) {
		for (Post post: posts) {
			if (post.getId().equals(id)) 
				return post;
			
		}
		return null;
	}

	public Post searchByIdStream(Long id) {
		return posts.stream().filter(item -> item.getId().equals(id)).findFirst().orElse(null);
	}
	
	public void deletePost(Long id) {
		posts.removeIf(item -> item.getId().equals(id));
		
	}

	public Long createPost(Post post) {
		this.currentId++;
		
		post.setId(this.currentId);
		posts.add(post);
		
		
		return post.getId();
	}

	public Post updatePost(Post post) {
		for (Post currentPost : posts) {
			if (currentPost.getId().equals(post.getId())){
				currentPost.setAuthor(post.getAuthor());
				currentPost.setTitle(post.getTitle());
				
				return currentPost;
			}
		}
		return null;
	}	
}
