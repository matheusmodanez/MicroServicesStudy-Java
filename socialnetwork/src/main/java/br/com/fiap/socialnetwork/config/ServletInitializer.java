package br.com.fiap.socialnetwork.config;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import br.com.fiap.socialnetwork.Application;

public class ServletInitializer extends SpringBootServletInitializer{
	@Override
	
	protected SpringApplicationBuilder configure (SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}
}
