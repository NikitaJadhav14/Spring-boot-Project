package com.jsp.product.category.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.product.category.dao.ProductDao;
import com.jsp.product.category.dto.Product;
import com.jsp.product.category.dto.ResponseStructure;

@Service
public class ProductService {
	@Autowired
	ProductDao productDao;

	public ResponseStructure<Product> saveProduct(Product product) {
		ResponseStructure<Product> responseStructure = new ResponseStructure<Product>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(productDao.saveProduct(product));
		return responseStructure;
	}

	public ResponseStructure<List<Product>> getAllProduct() {
		List<Product> products = productDao.getAllProduct();
		ResponseStructure<List<Product>> responseStructure = new ResponseStructure<List<Product>>();
		if (products != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(products);

		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("Product Ids Does not exist");
			responseStructure.setData(null);
		}
		return responseStructure;
	}

	public ResponseStructure<Product> updateProduct(int id, Product product) {
		Product product2 = productDao.getProductById(id);
		ResponseStructure<Product> responseStructure = new ResponseStructure();
		if (product2 != null) {
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(productDao.updateProduct(id, product2));
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("Not found Product id");
			responseStructure.setData(null);

		}
		return responseStructure;
	}

	public ResponseStructure<Product> getProductById(int id) {
		Product category = productDao.getProductById(id);
		ResponseStructure<Product> responseStructure = new ResponseStructure();
		if (category != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(category);

		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("Product Id Does not exist");
			responseStructure.setData(null);

		}
		return responseStructure;
	}

	public ResponseStructure<String> deleteProduct(int id) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		boolean flag = productDao.deleteProduct(id);
		if (flag) {
			responseStructure.setData("Data deleted");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Deleted");
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("Product Id Does not exist");
			responseStructure.setData(null);

		}
		return responseStructure;
	}

}
