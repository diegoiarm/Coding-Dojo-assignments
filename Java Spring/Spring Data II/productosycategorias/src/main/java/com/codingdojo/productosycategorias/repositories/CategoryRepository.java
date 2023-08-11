package com.codingdojo.productosycategorias.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.productosycategorias.models.Category;
import com.codingdojo.productosycategorias.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	List<Category> findAll();

	List<Category> findByProductsNotContains(Product product);

	Optional<Category> findById(Long id);
}