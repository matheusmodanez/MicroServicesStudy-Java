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
@RequestMapping("comments")
public class CommentController {
	private CommentRepository commentRepository = new CommentRepository();

	// Create
	@PostMapping
	public Long createComment(Comment comment) {
		return commentRepository.createComment(comment);
	}

	// Retrieve/Repeat
	@GetMapping
	public List<Comment> listComments() {
		return commentRepository.listComments();
	}

	@GetMapping("{id}")
	public Comment searchById(@PathVariable Long id) {
		return commentRepository.searchById(id);
	}

	// Update
	@PutMapping
	public Comment updateComment(Comment comment) {
		return commentRepository.updateComment(comment);
	}

	// Delete
	@DeleteMapping("{id}")
	public void deleteComment(@PathVariable Long id) {
		commentRepository.deleteComment(id);
	}
}
