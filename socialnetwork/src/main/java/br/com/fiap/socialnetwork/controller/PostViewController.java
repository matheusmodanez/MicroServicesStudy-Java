package br.com.fiap.socialnetwork.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import br.com.fiap.socialnetwork.model.Post;
import br.com.fiap.socialnetwork.repository.PostRepository;

@Controller
@RequestMapping("posts")
public class PostViewController {

	private PostRepository postRepository;

	public PostViewController(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	@GetMapping
	public String listPosts(Model model) {
		model.addAttribute("posts", postRepository.findAll());
		return "post/list";
	}

	@GetMapping("/form")
	public String showForm(Model model) {
		model.addAttribute("post", new Post());
		return "post/form";
	}

	@PostMapping("/save")
	public RedirectView savePost(@ModelAttribute("post") Post post, RedirectAttributes attrs) {
		// salvar o post

		Post savedPost = postRepository.save(post);

		// redirecionar para a tela de cadastros GET /addPost
		attrs.addFlashAttribute("addPostSucess", true);
		attrs.addFlashAttribute("savedPost", savedPost);

		RedirectView redirectView = new RedirectView("/posts");
		return redirectView;
	}

	@GetMapping("/{id}/delete")
	public RedirectView delete(@PathVariable Long id) {
		postRepository.deleteById(id);
		RedirectView redirectView = new RedirectView("/posts");
		return redirectView;
	}

	@GetMapping("/{id}")
	public String findById(@PathVariable Long id, Model model) {
		model.addAttribute("post", postRepository.findById(id).get());
		return "post/form";
	}
}