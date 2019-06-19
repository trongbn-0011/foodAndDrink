package app.model;

public class Rate {
	
	private Integer id;
	private Float point;
	private String comment;
	private User user;
	private Product product;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Float getPoint() {
		return point;
	}
	
	public void setPoint(Float point) {
		this.point = point;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
}
