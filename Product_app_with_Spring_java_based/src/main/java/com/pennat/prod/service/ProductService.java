package com.pennat.prod.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pennat.prod.model.Product;

@Service
public interface ProductService {
	void addProduct(Product prod);

	List<Product> listProducts();

	Product findProduct(int prodId);

	void deleteProduct(int prodId);

	void updateProduct(int prodId, String newProd);

}
