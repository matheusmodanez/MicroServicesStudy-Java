package br.com.fiap.study_mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.github.acnaweb.study_microservice.Post;
import com.github.acnaweb.study_microservice.PostRepository;

@Controller
@RequestMapping("posts")
public class PostViewController {

	private PostRepository postRepository;

	public PostViewController(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	@GetMapping
	public String viewPosts(Model model) {
		model.addAttribute("instituicao", "FIAP");
		model.addAttribute("posts", postRepository.listarTodos());
		return "view-posts";
	}

	@GetMapping("/addPost")
	public String addPostView(Model model) {
		model.addAttribute("post", new Post());
		return "add-post";
	}
	
	@GetMapping("/{id}")
	public String findById(@PathVariable Long id, Model model){
		model.addAttribute("post", postRepository.pesquisarPorId(id));
		return "add-post";
	}

	@PostMapping("/addPost")
	public RedirectView addPost(@ModelAttribute("post") Post post, RedirectAttributes attrs) {
		// salvar o post
		Long id = postRepository.adicionar(post);
		Post savedPost = postRepository.pesquisarPorId(id);

		// redirecionar para a tela de cadastros GET /addPost
		attrs.addFlashAttribute("addPostSuccess", true);
		attrs.addFlashAttribute("savedPost", savedPost);
		RedirectView redirectView = new RedirectView("/view/addPost");
		return redirectView;
	}
}
