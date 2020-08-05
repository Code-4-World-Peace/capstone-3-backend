package com.code4worldpeace.capstone3.Products.Model;

import java.util.*;

import javax.persistence.*;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(unique = true, nullable = false)
	private String sku;
	@Column(unique = true, nullable = false)
	private String name;
	private int stock;
	
	public Product(String sku, String name, int stock) {
		this.sku = sku;
		this.name = name;
		this.stock = stock;
	}
	public Product() {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
