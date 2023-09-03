package com.jsp.product.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.product.category.dto.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
