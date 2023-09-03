package com.jsp.product.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.product.category.dto.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
