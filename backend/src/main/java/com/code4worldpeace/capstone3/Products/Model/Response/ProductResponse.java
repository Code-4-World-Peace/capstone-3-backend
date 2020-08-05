package com.code4worldpeace.capstone3.Products.Model.Response;

import java.util.List;

public class ProductResponse {

	private String sku;
	private String name;
	private int stock;
	
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
}
