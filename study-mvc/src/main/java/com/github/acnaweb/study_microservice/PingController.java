package com.github.acnaweb.study_microservice;

import java.time.Instant;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ping")
public class PingController {

	// localhost:8080/ping Endpoint
	@GetMapping("/ping") // path
	public String ping() {
		return "pong";
	}

	@GetMapping("/now") // Endpoint
	public String now() {
		return Instant.now().toString();
	}

	// http://localhost:8080/antonio

	@GetMapping("/{nome}")
	public String welcome(@PathVariable String nome) {
		return "O dia está bom " + nome;
	}

	@GetMapping("/") // Endpoint
	public String root() {
		return "root";
	}

	// http://localhost:8080/parametros?nome=AC&pais=Brasil
	@GetMapping("/parametros")
	public String parametros(@RequestParam String nome, @RequestParam String pais) {
		return "Seja bem vindo(a) ao " + pais + ", " + nome;
	}

}
