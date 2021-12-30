package com.example.demo.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.course.entities.Product;
import com.example.demo.course.services.ProductService;

//recurso web implementado por um controlador rest

@RestController
@RequestMapping(value = "/products")//nome do recurso
public class ProductResource {
	
	@Autowired
	private ProductService service;
	
	//metodo endpoint para acessar usuarios .. retorna respostas de recursos web
	//identifica metodo get do http
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);//retorna ok e o corpo da resposta
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id){
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
