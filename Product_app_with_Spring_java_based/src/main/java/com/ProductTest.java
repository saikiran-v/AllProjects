package com;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pennat.prod.model.Product;
import com.pennat.prod.service.ProductService;
import com.pennat.prod.service.ProductServiceImpl;

public class ProductTest {
	@Autowired
	public static ProductService prodService;

	public ProductTest(ProductService prodService) {
		super();
		this.prodService = prodService;
	}

	public static void main(String[] args) {
		// ApplicationContext ac = new
		// ClassPathXmlApplicationContext("applicationContext.xml");
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(app.class);

		Scanner sc = new Scanner(System.in);
		Product prod = null;
		while (true) {
			System.out.println("MENU");
			System.out.println("1.Add product");
			System.out.println("2.List Products");
			System.out.println("3.Find Product");
			System.out.println("4.Delete Product");
			System.out.println("5.Update Product");
			System.out.println("8.Exit");
			System.out.println("Enter Choice: ");
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				Product p1 = new Product();
				System.out.println("Enter productId to add");
				int v1 = sc.nextInt();
				System.out.println("Enter productName to add");
				String s11 = sc.next();

				p1.setProdId(v1);
				p1.setProdName(s11);
				p1.setPrice(9447);
				prodService.addProduct(p1);
				break;
			case 2:
				List<Product> prods = prodService.listProducts();
				Product.display(prods);
				break;
			case 3:
				System.out.println("Enter productId to search");
				prod = prodService.findProduct(sc.nextInt());
				if (prod != null) {
					System.out.println("Product Id: " + prod.getProdId());
					System.out.println("Prod Name: " + prod.getProdName());
					System.out.println("Price: " + prod.getPrice());
					System.out.println("-------------------------------");
				} else {
					System.out.println("product Id not found");
				}
				break;
			case 4:
				System.out.println("Enter productId to delete");
				prodService.deleteProduct(sc.nextInt());
				break;
			case 5:

				System.out.println("Enter productId to update");
				int v = sc.nextInt();
				System.out.println("Enter productName to update");
				String s1 = sc.next();
				prodService.updateProduct(v, s1);

				break;
			case 8:
				System.exit(0);
			default:
				System.out.println("Invalid Choice. try again");
			}

		}

	}

}
