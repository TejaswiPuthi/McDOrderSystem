package main.java.api;

import java.util.ArrayList;
import java.util.List;

public class ProductOrdersList {
	
	public static List<Product> products = new ArrayList<>();
	
	public List<Product> getProductOrderList(){
		return products;
	}
	
	public void addProduct(Product product){
		products.add(product);
	}

}
