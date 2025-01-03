package com.gearing.productsandcategories.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
		Optional<Product> product = productServ.getProductById(id);
		if(product.isEmpty())
			return "redirect:/";
		
		model.addAttribute("product", product.get());
		model.addAttribute("productcategories", categoryServ.allCategories());
		
		return "productdisplay.jsp";
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
