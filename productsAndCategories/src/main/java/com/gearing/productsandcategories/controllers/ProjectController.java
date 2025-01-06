package com.gearing.productsandcategories.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gearing.productsandcategories.models.Category;
import com.gearing.productsandcategories.models.Product;
import com.gearing.productsandcategories.services.CategoryService;
import com.gearing.productsandcategories.services.ProductService;

import jakarta.validation.Valid;

@Controller
public class ProjectController {
	@Autowired
	private ProductService productServ;
	@Autowired
	private CategoryService categoryServ;
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("products", productServ.allProducts());
		model.addAttribute("categories", categoryServ.allCategories());
		
		return "homepage.jsp";
	}
	
	@GetMapping("/products/new")
	public String addProduct(Model model, @ModelAttribute Product product) {
		
		return "productform.jsp";
	}
	
	@GetMapping("/categories/new")
	public String addCategory(Model model, @ModelAttribute Category category) {
		
		return "categoryform.jsp";
	}
	
	@GetMapping("/products/{id}")
	public String productDetails(Model model, @PathVariable Long id) {
		Optional<Product> optionalProduct = productServ.getProductById(id);
		if(optionalProduct.isEmpty())
			return "redirect:/";
		
		Product product = optionalProduct.get();
		List<Category> productcategories = categoryServ.allByProduct(product);
		List<Category> othercategories = categoryServ.allProductsNotContains(product);
		
		model.addAttribute("product", product);
		model.addAttribute("productcategories", productcategories);
		model.addAttribute("othercategories", othercategories);
		
		return "productdisplay.jsp";
	}
	
	@PutMapping("/products/{productId}/add")
	public String addToProduct(@PathVariable Long productId, @RequestParam Long categoryId) {
		productServ.addCategoryToProduct(categoryId, productId);
		
		return "redirect:/products/" + productId;
	}
	
	@GetMapping("/categories/{id}")
	public String categoryDetails(Model model, @PathVariable Long id) {
		Optional<Category> optionalCategory = categoryServ.getCategoryById(id);
		if(optionalCategory.isEmpty())
			return "redirect:/";
		
		Category category = optionalCategory.get();
		List<Product> categoryproducts = productServ.allByCategory(category);
		List<Product> otherproducts = productServ.allProductsNotTiedTo(category);
		
		model.addAttribute("category", category);
		model.addAttribute("categoryproducts", categoryproducts);
		model.addAttribute("otherproducts", otherproducts);
		
		return "categorydisplay.jsp";
	}
	
	@PutMapping("/categories/{categoryId}/add")
	public String addToCategory(@PathVariable Long categoryId, @RequestParam Long productId) {
		productServ.addCategoryToProduct(categoryId, productId);
		
		return "redirect:/categories/" + categoryId;
	}
	
	@PostMapping("/products/create")
	public String createProduct(Model model, @Valid @ModelAttribute Product product, BindingResult result) {
		if(result.hasErrors())
			return "productform.jsp";
		
		productServ.addProduct(product);
		return "redirect:/";
	}
	
	@PostMapping("/categories/create")
	public String createCategory(Model model, @Valid @ModelAttribute Category category, BindingResult result) {
		if(result.hasErrors())
			return "categoryform.jsp";
		
		categoryServ.addCategory(category);
		return "redirect:/";
	}
}
