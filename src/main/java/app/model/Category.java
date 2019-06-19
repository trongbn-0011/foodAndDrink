package app.model;

import java.util.List;

public class Category {
	
	private Integer id;
	private String name;
	private Integer parentId;
	private List<Product> products;
	
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
	
	public Integer getParentId() {
		return parentId;
	}
	
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
}
