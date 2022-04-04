package br.com.fiap.p_86065.checkpoint;

import java.util.ArrayList;
import java.util.List;

public class CommentRepository {
	private List<Comment> comments;
	private long currentComment = 0;

	public CommentRepository() {
		this.load();
	}

	private void load() {
		comments = new ArrayList<Comment>();
	}

	public List<Comment> listarTodos() {
		return comments;
	}

	public Comment pesquisarPorId(Long id) {
		return comments.stream().filter(comment -> comment.getId().equals(id)).findFirst().orElse(null);
	}

	public void apagarPorId(Long id) {
		comments.removeIf(comment -> comment.getId().equals(id));
	}

	public Comment atualizar(Comment comment) {
		for (Comment c : comments) {
			if (c.getId().equals(comment.getId())) {
				c.setBody(comment.getBody());
				c.setPostId(comment.getPostId());

				return c;
			}
		}
		return null;
	}

	public Long adicionar(Comment comment) {
		this.currentComment++;
		
		comment.setId(this.currentComment);
		comments.add(comment);

		return comment.getId();
	}

}
