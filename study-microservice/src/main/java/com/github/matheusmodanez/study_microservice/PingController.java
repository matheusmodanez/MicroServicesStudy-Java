package com.github.matheusmodanez.study_microservice;

import java.time.Instant;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

	@GetMapping("/ping")
	public String ping() {
		return "pong";
	}
	
	@GetMapping("/now")
	public String now() {
		return Instant.now().toString();
	}
	
	@GetMapping("/{nome}")
	public String welcome(@PathVariable String nome) {
		return "Olá "+nome;
	}
	
	@GetMapping("/parametros")
	public String welcome(@RequestParam String nome, @RequestParam String pais) {
		return "Seja bem vindo a: "+pais+", " + nome;
	}
}
