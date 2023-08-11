package com.codingdojo.productosycategorias.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.productosycategorias.models.Category;
import com.codingdojo.productosycategorias.models.CategoryProduct;
import com.codingdojo.productosycategorias.models.Product;

public interface CategoryProductRepository extends CrudRepository<CategoryProduct, Long> {

	List<CategoryProduct> findAll();

	Integer countBy();

	Optional<CategoryProduct> findById(Long id);

	Optional<CategoryProduct> findByCategoryAndProduct(Category category, Product product);

}