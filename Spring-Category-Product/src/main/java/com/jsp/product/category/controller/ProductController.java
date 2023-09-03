package com.jsp.product.category.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.product.category.dto.Product;
import com.jsp.product.category.dto.ResponseStructure;
import com.jsp.product.category.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	ProductService productService;

	@PostMapping("/api/products")
	public ResponseStructure<Product> saveProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}

	@GetMapping("/api/products/{id}")
	public ResponseStructure<Product> getProduct(@PathVariable int id) {
		return productService.getProductById(id);
	}

	@PutMapping("api/products/{id}")
	public ResponseStructure<Product> updateAdmin(@PathVariable int id, @RequestBody Product product) {
		return productService.updateProduct(id, product);
	}

	@DeleteMapping("api/products/{id}")
	public ResponseStructure<String> deleteAdmin(@PathVariable int id) {
		return productService.deleteProduct(id);
	}

	@GetMapping("api/products")
	public ResponseStructure<List<Product>> getAllProducts() {
		return productService.getAllProduct();
	}

}
