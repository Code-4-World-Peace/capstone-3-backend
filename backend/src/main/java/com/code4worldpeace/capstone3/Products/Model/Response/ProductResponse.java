package com.code4worldpeace.capstone3.Products.Model.Response;

import java.util.List;

public class ProductResponse {

	private String sku;
	private String name;
	private String description;
	private String heat;
	private String flavor;
	private double price;
	private String image;
	private String tag;
	private int stock;
	private String stripePrice;
	
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
