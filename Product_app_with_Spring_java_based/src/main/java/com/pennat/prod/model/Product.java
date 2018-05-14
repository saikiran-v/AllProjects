package com.pennat.prod.model;

import java.util.List;

public class Product {

	private int prodId;
	private String prodName;
	private double price;

	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	public static void display(List<Product> prods) {
		
		System.out.println("ProdId\tProdName\tPrice");
		System.out.println("-----------------------------");
		for(Product prod:prods) {
			System.out.print(prod.getProdId()+"\t"+prod.getProdName()+"\t"+prod.getPrice());
			System.out.println();
		}
		System.out.println("-----------------------------");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
