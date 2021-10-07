package com.commentator;

import com.commentator.controllers.UserController;
import com.commentator.models.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CommentatorApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CommentatorApplication.class, args);
		System.out.println("hello world");
		//UserController userController = (UserController) context.getBean("userController");
		//User user = new User("username", "email@email.com", "password");
		//userController.saveUser(user);

	}
	/*
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/greeting-javaconfig").allowedOrigins("http://localhost:8080","http://localhost:3000");
			}
		};
	}*/

}
