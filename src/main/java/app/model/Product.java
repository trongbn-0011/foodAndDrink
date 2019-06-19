package app.model;

import java.util.List;

public class Product {
	
	private Integer id;  
	private String name;
	private String description;
	private Float price;
	private Float avgRate;
	private Integer quantity;
	private Category category;
	private List<OrderProduct> orderProducts;
	private List<Rate> rates;
	
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
	
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}

	public List<OrderProduct> getOrderProducts() {
		return orderProducts;
	}

	public void setOrderProducts(List<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	}

	public List<Rate> getRates() {
		return rates;
	}

	public void setRates(List<Rate> rates) {
		this.rates = rates;
	}
	
}
