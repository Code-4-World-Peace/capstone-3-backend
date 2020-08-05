package com.code4worldpeace.capstone3.Products.Model.Request;

import java.util.List;

public class ProductRequest {

	private String name;
	private int stock;
	
	public ProductRequest(String name, int stock) {

		this.name = name;
		this.stock = stock;
	}
	public ProductRequest() {
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
