package com.arabsoft.pos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.arabsoft.pos.modules.Category;

public interface CategoryRepository extends CrudRepository<Category,Long> {
	public List<Category> findAll();
}