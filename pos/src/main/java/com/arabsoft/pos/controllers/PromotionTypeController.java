package com.arabsoft.pos.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.arabsoft.pos.modules.PromotionType;
import com.arabsoft.pos.repositories.PromotionTypeRepository;

@RestController
public class PromotionTypeController {

	private final PromotionTypeRepository repo;
	
	PromotionTypeController(PromotionTypeRepository repo){
		this.repo = repo;
	}
	
	@GetMapping("/PromotionTypes")
	List<PromotionType> all(){
		return repo.findAll();
	}
	
	@PostMapping(path = "/PromotionTypes/Add",consumes = MediaType.APPLICATION_JSON_VALUE)
	PromotionType newPromotionType(@RequestBody PromotionType newPromotionType) {
	    return repo.save(newPromotionType);
	}
	
	@GetMapping("/PromotionTypes/{id}")
	PromotionType one(@PathVariable Long id) {    
	    return repo.findById(id).orElseThrow();
	}
	
	@PutMapping(path = "/PromotionTypes/Update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	PromotionType update(@RequestBody PromotionType newPromotionType, @PathVariable Long id) {
		Optional<PromotionType> oldPromotionType = repo.findById(id);
		if(oldPromotionType.isPresent()) {
			oldPromotionType.get().setName(newPromotionType.getName());
			oldPromotionType.get().setDiscount_percent(newPromotionType.getDiscount_percent());
			oldPromotionType.get().setPromotions(newPromotionType.getPromotions());
			return repo.save(oldPromotionType.get());
		}else {
			return oldPromotionType.orElseThrow();
		}
	}
	
	@DeleteMapping("/PromotionTypes/Delete/{id}")
	void delete(@PathVariable Long id) {
		repo.deleteById(id);
	}
}
