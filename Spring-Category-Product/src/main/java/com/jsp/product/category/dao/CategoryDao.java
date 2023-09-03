package com.jsp.product.category.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.product.category.dto.Category;
import com.jsp.product.category.repository.CategoryRepository;

@Repository
public class CategoryDao {
	@Autowired
	CategoryRepository categoryRepository;

	public Category saveCategory(Category category) {
		return categoryRepository.save(category);
	}

	public List<Category> getAllCategory() {
		return categoryRepository.findAll();
	}

	public Category updateCategory(int id, Category category) {
		Optional<Category> opt = categoryRepository.findById(id);
		if (opt.isEmpty()) {
			return null;
		} else {
			return categoryRepository.save(category);
		}
	}

	public Category getCategoryById(int id) {
		Optional<Category> opt = categoryRepository.findById(id);
		if (opt.isEmpty()) {
			return null;
		} else {

			return opt.get();
		}
	}

	public boolean deleteCategory(int id) {
		Optional<Category> optional = categoryRepository.findById(id);
		if (optional.isPresent()) {
			categoryRepository.delete(optional.get());
			return true;
		} else {
			return false;
		}
	}

}
