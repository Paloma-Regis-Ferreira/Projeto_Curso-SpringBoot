package com.example.demo.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.course.entities.Order;
import com.example.demo.course.services.OrderService;

//recurso web implementado por um controlador rest

@RestController
@RequestMapping(value = "/orders")//nome do recurso
public class OrderResource {
	
	@Autowired
	private OrderService service;
	
	//metodo endpoint para acessar usuarios .. retorna respostas de recursos web
	//identifica metodo get do http
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list);//retorna ok e o corpo da resposta
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
