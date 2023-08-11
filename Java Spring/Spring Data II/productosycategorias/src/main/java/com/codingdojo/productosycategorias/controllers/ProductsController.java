package com.codingdojo.productosycategorias.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.productosycategorias.models.Product;
import com.codingdojo.productosycategorias.services.ProductService;
import com.codingdojo.productosycategorias.services.CategoryProductService;
import com.codingdojo.productosycategorias.services.CategoryService;
import com.codingdojo.productosycategorias.models.Category;
import com.codingdojo.productosycategorias.models.CategoryProduct;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductsController {

	private final ProductService productService;

	private final CategoryService categoryService;
	private final CategoryProductService categoryProductService;

	public ProductsController(ProductService productService, CategoryService categoryService,
			CategoryProductService categoryProductService) {
		this.productService = productService;
		this.categoryService = categoryService;
		this.categoryProductService = categoryProductService;
	}

	@GetMapping("/new")
	public String newProductForm(Model model) {
		model.addAttribute("product", new Product());
		return "/Views/product.jsp";
	}

	@PostMapping("/new")
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "/Views/product.jsp";
		} else {
			productService.createProduct(product);
			return "redirect:/products/new";
		}
	}

	@GetMapping("/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model) {
		Optional<Product> optionalProduct = productService.encontrarProductPorId(id);
		if (optionalProduct.isPresent()) {
			Product product = optionalProduct.get();
			List<Category> categories = categoryService.nullCategory(product);
			model.addAttribute("categories", categories);
			model.addAttribute("product", product);
			return "/Views/showProduct.jsp";
		} else {

			return "/Views/error.jsp";
		}
	}

	@PostMapping("/{id}")
	public String createCategoryProduct(@ModelAttribute("category_product") CategoryProduct categoryproduct,
			@PathVariable("id") Long id, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/products/" + id;
		} else {
			categoryProductService.createOrUpdateCategoryProduct(categoryproduct);
			return "redirect:/products/" + id;
		}
	}
}