package com.jsp.product.category.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jsp.product.category.dto.Category;
import com.jsp.product.category.dto.ResponseStructure;
import com.jsp.product.category.service.CategoryService;

public class CategoryController {
	@Autowired
	CategoryService categoryService;

	@PostMapping("/api/categories")
	public ResponseStructure<Category> saveCategory(@RequestBody Category category) {
		return categoryService.saveCategory(category);
	}

	@GetMapping("/api/categories/{id}")
	public ResponseStructure<Category> getCategory(@PathVariable int id) {
		return categoryService.getCategoryById(id);
	}

	@PutMapping("api/categories/{id}")
	public ResponseStructure<Category> updateCategory(@PathVariable int id, @RequestBody Category category) {
		return categoryService.updateCategory(id, category);
	}

	@DeleteMapping("api/categories/{id}")
	public ResponseStructure<String> deleteCategory(@PathVariable int id) {
		return categoryService.deleteCategory(id);
	}

	@GetMapping("api/categories")
	public ResponseStructure<List<Category>> getAllCategories() {
		return categoryService.getAllCategory();
	}
}
