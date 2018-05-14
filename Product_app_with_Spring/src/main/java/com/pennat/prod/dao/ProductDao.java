package com.pennat.prod.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.pennat.prod.model.Product;

@Repository
public interface ProductDao {
	static final String INSERT_PRODUCT = "insert into product values(?,?,?)";
	static final String SELECT_ALL_PRODUCT = "select prodId,prodname,price from product";
	static final String SELECT_PRODUCT = "select prodId,prodname,price from product where prodid=?";
	static final String DELETE_PRODUCT = "delete  product where prodid=?";
	static final String UPDATE_PRODUCT = "update product set prodname=? where prodid=?";

	void addProduct(Product prod);

	List<Product> listProducts();

	Product findProduct(int prodId);

	void deleteProduct(int prodId);

	void updateProduct(int prodId, String newProd);
	public List<Map<String,Object>> getProducts();

}
