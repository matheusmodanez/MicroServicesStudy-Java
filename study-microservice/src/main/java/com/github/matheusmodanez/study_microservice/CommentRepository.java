package com.github.matheusmodanez.study_microservice;

import java.util.ArrayList;
import java.util.List;

public class CommentRepository {
	private List<Comment> comments;
	private long currentId = 1;

	public CommentRepository() {
		this.load();
	}

	private void load() {
		comments = new ArrayList<Comment>();

		Comment comment = new Comment();
		comment.setId(1L);
		comment.setBody("some comment");
		comment.setPostId(1L);

		comments.add(comment);
	}

	public Long createComment(Comment comment) {
		this.currentId++;

		comment.setId(this.currentId);
		comments.add(comment);

		return comment.getId();
	}

	public List<Comment> listComments() {
		return comments;
	}

	public Comment searchById(Long id) {
		return comments.stream().filter(comment -> comment.getId().equals(id)).findFirst().orElse(null);
	}

	public Comment updateComment(Comment comment) {
		for (Comment currentComment : comments) {
			if (currentComment.getId().equals(comment.getId())) {
				currentComment.setBody(comment.getBody());
				currentComment.setPostId(comment.getPostId());

				return currentComment;
			}
		}
		return null;
	}

	public void deleteComment(Long id) {
		comments.removeIf(comment -> comment.getId().equals(id));
	}

}
