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
	@Column(nullable = false)
	private String description;
	@Column(nullable = false)
	private String heat;
	@Column(nullable = false)
	private String flavor;
	@Column(nullable = false)
	private double price;
	@Column(nullable = false)
	private String image;
	@Column(nullable = false)
	private String tag;
	@Column(nullable = false)
	private int stock;
	@Column(nullable = false)
	private String stripePrice;
	
	public Product(String sku, String name, String description, String heat, String flavor,
			double price, String image, String tag, int stock, String stripePrice) {
		this.sku = sku;
		this.name = name;
		this.description = description;
		this.heat = heat;
		this.flavor = flavor;
		this.price = price;
		this.image = image;
		this.tag = tag;
		this.stock = stock;
		this.stripePrice = stripePrice;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHeat() {
		return heat;
	}

	public void setHeat(String heat) {
		this.heat = heat;
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getStripePrice() {
		return stripePrice;
	}

	public void setStripePrice(String stripePrice) {
		this.stripePrice = stripePrice;
	}
	
}
