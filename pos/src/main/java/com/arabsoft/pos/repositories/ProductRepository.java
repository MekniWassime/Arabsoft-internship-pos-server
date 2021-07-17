package com.arabsoft.pos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.arabsoft.pos.modules.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	public List<Product> findAll();
}
