package com.pennat.prod.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pennat.prod.dao.ProductDao;
import com.pennat.prod.dao.ProductDaoImpl;
import com.pennat.prod.model.Product;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao prodDao ;

	public void addProduct(Product prod) {
		prodDao.addProduct(prod);

	}
	
	

	public ProductDao getProdDao() {
		return prodDao;
	}


	public void setProdDao(ProductDao prodDao) {
		this.prodDao = prodDao;
	}


	public List<Product> listProducts() {
		// TODO Auto-generated method stub
		return prodDao.listProducts();
	}

	public Product findProduct(int prodId) {
		// TODO Auto-generated method stub
		return prodDao.findProduct(prodId);
	}

	public void deleteProduct(int prodId) {
		prodDao.deleteProduct(prodId);

	}

	public void updateProduct(int prodId, String newProd) {
		prodDao.updateProduct(prodId, newProd);

	}

}
