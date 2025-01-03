package com.gearing.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gearing.productsandcategories.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	List<Category> findAll();
}
