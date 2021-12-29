package com.example.demo.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.course.entities.User;

//recurso web implementado por um controlador rest

@RestController
@RequestMapping(value = "/users")//nome do recurso
public class UserResource {
	
	//metodo endpoint para acessar usuarios .. retorna respostas de recursos web
	//identifica metodo get do http
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Maria", "maria@gmail.com", "9999999", "12345");
		return ResponseEntity.ok().body(u);//retorna ok e o corpo da resposta
	}
}
