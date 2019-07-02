package app.bean;

import java.util.List;

import app.model.Product;

public class ProductInfo {
	
	private Integer id;  
	private String name;
	private String description;
	private String image;
	private Float price;
	private Float avgRate;
	private Integer quantity;
	
	public ProductInfo() {
		
	}
	
	public ProductInfo(Product product) {
		this.id = product.getId();
		this.name = product.getName();
		this.description = product.getDescription();
		this.image = product.getImage();
		this.price = product.getPrice();
		this.avgRate = product.getAvgRate();
		this.quantity = product.getQuantity();
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
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
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public Float getPrice() {
		return price;
	}
	
	public void setPrice(Float price) {
		this.price = price;
	}
	
	public Float getAvgRate() {
		return avgRate;
	}
	
	public void setAvgRate(Float avgRate) {
		this.avgRate = avgRate;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
}
