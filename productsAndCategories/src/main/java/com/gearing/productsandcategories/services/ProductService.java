package com.gearing.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gearing.productsandcategories.models.Category;
import com.gearing.productsandcategories.models.Product;
import com.gearing.productsandcategories.repositories.CategoryRepository;
import com.gearing.productsandcategories.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepo;
	@Autowired
	private CategoryRepository categoryRepo;
	
	public List<Product> allProducts() {
		return productRepo.findAll();
	}
	
	public Optional<Product> getProductById(Long id) {
		return productRepo.findById(id);
	}
	
	public Product addProduct(Product product) {
		return productRepo.save(product);
	}
	
	public Product updateProduct(Product product) {
		return productRepo.save(product);
	}
	
	public void addCategoryToProduct(Long categoryId, Long productId) {
		Category category = categoryRepo.findById(categoryId).get();
		Product product = productRepo.findById(productId).get();
		
		product.getCategories().add(category);
		
		productRepo.save(product);
	}
	
	public List<Product> allByCategory(Category category) {
		return productRepo.findAllByCategories(category);
	}
	
	public List<Product> allProductssNotTiedTo(Category category) {
		return productRepo.findByCategoriesNotContains(category);
	}
}
