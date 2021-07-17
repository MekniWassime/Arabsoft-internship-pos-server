package com.arabsoft.pos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.arabsoft.pos.modules.PromotionType;

public interface PromotionTypeRepository extends CrudRepository<PromotionType, Long> {
	public List<PromotionType> findAll();
}
