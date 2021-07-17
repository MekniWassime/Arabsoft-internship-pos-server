package com.arabsoft.pos.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.arabsoft.pos.modules.Product;
import com.arabsoft.pos.repositories.ProductRepository;

@RestController
public class ProductController {

	private final ProductRepository repo;
	
	ProductController(ProductRepository repo){
		this.repo = repo;
	}
	
	@GetMapping("/Products")
	List<Product> all(){
		return repo.findAll();
	}
	
	@PostMapping(path = "/Products/Add",consumes = MediaType.APPLICATION_JSON_VALUE)
	Product newProduct(@RequestBody Product newProduct) {
		return repo.save(newProduct);
	}
	
	@GetMapping("/Products/{id}")
	Product one(@PathVariable Long id) {    
	    return repo.findById(id).orElseThrow();
	}
	
	@PutMapping(path = "/Products/Update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	Product update(@RequestBody Product newProduct, @PathVariable Long id) {
		Optional<Product> oldProduct = repo.findById(id);
		if(oldProduct.isPresent()) {
			oldProduct.get().setName(newProduct.getName());
			oldProduct.get().setPrice(newProduct.getPrice());
			oldProduct.get().setDescription(newProduct.getDescription());
			oldProduct.get().setImageUrl(newProduct.getImageUrl());
			oldProduct.get().setCategory(newProduct.getCategory());
			return repo.save(oldProduct.get());
		}else {
			return oldProduct.orElseThrow();
		}
	}
	
	@DeleteMapping("/Products/Delete/{id}")
	void delete(@PathVariable Long id) {
		repo.deleteById(id);
	}
}
