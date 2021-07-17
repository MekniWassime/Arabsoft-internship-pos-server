package com.arabsoft.pos.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.arabsoft.pos.modules.Promotion;
import com.arabsoft.pos.repositories.PromotionRepository;

@RestController
public class PromotionController {

	private final PromotionRepository repo;
	
	PromotionController(PromotionRepository repo){
		this.repo = repo;
	}
	
	@GetMapping("/Promotions")
	List<Promotion> all(){
		return repo.findAll();
	}
	
	@PostMapping(path = "/Promotions/Add",consumes = MediaType.APPLICATION_JSON_VALUE)
	Promotion newPromotion(@RequestBody Promotion newPromotion) {
		return repo.save(newPromotion);
	}
	
	@GetMapping("/Promotions/{id}")
	Promotion one(@PathVariable Long id) {    
	    return repo.findById(id).orElseThrow();
	}
	
	@PutMapping(path = "/Promotions/Update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	Promotion update(@RequestBody Promotion newPromotion, @PathVariable Long id) {
		Optional<Promotion> oldPromotion = repo.findById(id);
		if(oldPromotion.isPresent()) {
			oldPromotion.get(). setStart_date(newPromotion.getStart_date());
			oldPromotion.get().setEnd_date(newPromotion.getEnd_date());
			oldPromotion.get().setProduct(newPromotion.getProduct());
			oldPromotion.get().setPromotiontype(newPromotion.getPromotiontype());
			return repo.save(oldPromotion.get());
		}else {
			return oldPromotion.orElseThrow();
		}
	}
	
	@DeleteMapping("/Promotions/Delete/{id}")
	void delete(@PathVariable Long id) {
		repo.deleteById(id);
	}
}
