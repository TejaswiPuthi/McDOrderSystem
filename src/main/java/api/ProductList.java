package main.java.api;

import java.util.ArrayList;
import java.util.List;

public class ProductList {
	
	List<Product> products = new ArrayList<>();
	Product product;
	public ProductList() {
		product = new Product();
		product.setProductId(1);
		product.setProductName("MapleOatMeal");
		product.setProductPrice(100);
		product.setType("Veg");
		products.add(product);
		
		product = new Product();
		product.setProductId(2);
		product.setProductName("Sausage McGriddles");
		product.setProductPrice(120);
		product.setType("Non-Veg");
		products.add(product);
		
		
		product = new Product();
		product.setProductId(3);
		product.setProductName("Egg McMuffin");
		product.setProductPrice(210);
		product.setType("Non-Veg");
		products.add(product);
		
		
		
		product = new Product();
		product.setProductId(4);
		product.setProductName("HotChocolate");
		product.setProductPrice(120);
		product.setType("Veg");
		products.add(product);
		
		
		product = new Product();
		product.setProductId(5);
		product.setProductName("Classic Chicken Sandwich");
		product.setProductPrice(230);
		product.setType("Non-Veg");
		products.add(product);
		
		product = new Product();
		product.setProductId(6);
		product.setProductName("Hot Fudge Sundae");
		product.setProductPrice(98);
		product.setType("Veg");
		products.add(product);
		
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
