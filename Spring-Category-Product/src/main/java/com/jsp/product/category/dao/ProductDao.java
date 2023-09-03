package com.jsp.product.category.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.product.category.dto.Product;
import com.jsp.product.category.repository.ProductRepository;

@Repository
public class ProductDao {

	@Autowired
	ProductRepository productRepository;

	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

	public Product updateProduct(int id, Product product) {
		Optional<Product> opt = productRepository.findById(id);
		if (opt.isEmpty()) {
			return null;
		} else {
			return productRepository.save(product);
		}
	}

	public Product getProductById(int id) {
		Optional<Product> opt = productRepository.findById(id);
		if (opt.isEmpty()) {
			return null;
		} else {
			return opt.get();
		}
	}

	public boolean deleteProduct(int id) {
		Optional<Product> optional = productRepository.findById(id);
		if (optional.isPresent()) {
			productRepository.delete(optional.get());
			return true;
		} else {
			return false;
		}
	}
}
