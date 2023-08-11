package com.codingdojo.productosycategorias.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.productosycategorias.models.CategoryProduct;
import com.codingdojo.productosycategorias.repositories.CategoryProductRepository;

@Service
public class CategoryProductService {
	@Autowired
	private final CategoryProductRepository categoryProductRepository;

	public CategoryProductService(CategoryProductRepository categoryProductRepository) {
		this.categoryProductRepository = categoryProductRepository;
	}

	public List<CategoryProduct> allCategoryProduct() {
		return categoryProductRepository.findAll();
	}

	public CategoryProduct createOrUpdateCategoryProduct(CategoryProduct categoryProduct) {

		Optional<CategoryProduct> existingRelationship = categoryProductRepository
				.findByCategoryAndProduct(categoryProduct.getCategory(), categoryProduct.getProduct());

		if (existingRelationship.isPresent()) {

			CategoryProduct existing = existingRelationship.get();
			categoryProductRepository.save(categoryProduct);
			return categoryProductRepository.save(existing);
		} else {

			return categoryProductRepository.save(categoryProduct);
		}
	}

	public void deleteCategoryProduct(Long id) {
		categoryProductRepository.deleteById(id);
	}
}
