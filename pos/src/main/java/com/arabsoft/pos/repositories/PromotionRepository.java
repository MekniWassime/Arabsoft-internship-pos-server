package com.arabsoft.pos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.arabsoft.pos.modules.Promotion;

public interface PromotionRepository extends CrudRepository<Promotion, Long> {
	public List<Promotion> findAll();
}
