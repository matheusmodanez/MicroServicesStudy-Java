package br.com.fiap.p_86065.checkpoint;

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
@RequestMapping("comments")
public class CommentController {
	
	private CommentRepository commentRepository = new CommentRepository();

	@GetMapping
	public List<Comment> listarComments() {
		return commentRepository.listarTodos();
	}

	@GetMapping("{id}")
	public Comment pesquisarPorId(@PathVariable Long id) {
		return commentRepository.pesquisarPorId(id);
	}

	@DeleteMapping("{id}")
	public void apagarComment(@PathVariable Long id) {
		commentRepository.apagarPorId(id);
	}

	@PostMapping
	public Long criarComment(@RequestBody Comment comment) {
		return commentRepository.adicionar(comment);
	}

	@PutMapping
	public Comment atualizarComment(@RequestBody Comment comment) {
		return commentRepository.atualizar(comment);
	}

}
