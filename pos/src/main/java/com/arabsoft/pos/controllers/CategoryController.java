package com.arabsoft.pos.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.arabsoft.pos.modules.Category;
import com.arabsoft.pos.repositories.CategoryRepository;

@RestController
public class CategoryController {

	private final CategoryRepository repo;
	
	CategoryController(CategoryRepository repo){
		this.repo = repo;
	}
	
	@GetMapping("/Categories")
	List<Category> all(){
		return repo.findAll();
	}
	
	@PostMapping(path = "/Categories/Add",consumes = MediaType.APPLICATION_JSON_VALUE)
	Category newCategory(@RequestBody Category newCategory) {
	    return repo.save(newCategory);
	}
	
	@GetMapping("/Categories/{id}")
	Category one(@PathVariable Long id) {    
	    return repo.findById(id).orElseThrow();
	}
	
	@PutMapping(path = "/Categories/Update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	Category update(@RequestBody Category newCategory, @PathVariable Long id) {
		Optional<Category> oldCategory = repo.findById(id);
		if(oldCategory.isPresent()) {
			oldCategory.get().setName(newCategory.getName());
			//oldCategory.get().setProducts(newCategory.getProducts());
			return repo.save(oldCategory.get());
		}else {
			return oldCategory.orElseThrow();
		}
	}
	
	@DeleteMapping("/Cateogories/Delete/{id}")
	void delete(@PathVariable Long id) {
		repo.deleteById(id);
	}
}
