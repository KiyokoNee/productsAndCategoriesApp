package com.gearing.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gearing.productsandcategories.models.Category;
import com.gearing.productsandcategories.models.Product;
import com.gearing.productsandcategories.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepo;
	
	public List<Category> allCategories() {
		return categoryRepo.findAll();
	}
	
	public Optional<Category> getCategoryById(Long id) {
		return categoryRepo.findById(id);
	}
	
	public Category addCategory(Category category) {
		return categoryRepo.save(category);
	}
	
	public Category updateCategory(Category category) {
		return categoryRepo.save(category);
	}
	
	public List<Category> allByProduct(Product product) {
		return categoryRepo.findAllByProducts(product);
	}
	
	public List<Category> allProductsNotContains(Product product) {
		return categoryRepo.findByProductsNotContains(product);
	}
}
