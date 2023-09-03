package com.jsp.product.category.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.product.category.dao.CategoryDao;
import com.jsp.product.category.dto.Category;
import com.jsp.product.category.dto.ResponseStructure;

@Service
public class CategoryService {
	@Autowired
	CategoryDao categoryDao;

	public ResponseStructure<Category> saveCategory(Category category) {
		ResponseStructure<Category> responseStructure = new ResponseStructure<Category>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(categoryDao.saveCategory(category));
		return responseStructure;
	}

	public ResponseStructure<List<Category>> getAllCategory() {
		List<Category> categories = categoryDao.getAllCategory();
		ResponseStructure<List<Category>> responseStructure = new ResponseStructure<List<Category>>();
		if (categories != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(categories);

		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("Category Ids Does not exist");
			responseStructure.setData(null);
		}
		return responseStructure;
	}

	public ResponseStructure<Category> updateCategory(int id, Category category) {
		Category category2 = categoryDao.getCategoryById(id);
		ResponseStructure<Category> responseStructure = new ResponseStructure();
		if (category2 != null) {
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(categoryDao.updateCategory(id, category2));
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("Not found Category id");
			responseStructure.setData(null);

		}
		return responseStructure;
	}

	public ResponseStructure<Category> getCategoryById(int id) {
		Category category = categoryDao.getCategoryById(id);
		ResponseStructure<Category> responseStructure = new ResponseStructure();
		if (category != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(category);

		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("Category Id Does not exist");
			responseStructure.setData(null);

		}
		return responseStructure;
	}

	public ResponseStructure<String> deleteCategory(int id) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		boolean flag = categoryDao.deleteCategory(id);
		if (flag) {
			responseStructure.setData("Data deleted");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Deleted");
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("Category Id Does not exist");
			responseStructure.setData(null);

		}
		return responseStructure;
	}
}
