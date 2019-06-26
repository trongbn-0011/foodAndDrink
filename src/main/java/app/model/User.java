package app.model;

import java.util.List;

public class User {

	private Integer id;
	private String name;
	private String email;
	private String password;
	private String address;
	private String avatar;
	private Integer actived;
	private Integer role;
	private List<Order> orders;
	private List<Rate> rates;
	private List<Suggestion> suggestions;

	public User() {
	}

	public User(Integer id) {
		this.id = id;
	}

	public User(String name, String email, String password, String address, String avatar, Integer actived,
			Integer role) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
		this.avatar = avatar;
		this.actived = actived;
		this.role = role;
	}

	public User(Integer id, String name, String email, String password, String address, String avatar, Integer actived,
			Integer role) {	
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
		this.avatar = avatar;
		this.actived = actived;
		this.role = role;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Integer getActived() {
		return actived;
	}

	public void setActived(Integer actived) {
		this.actived = actived;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<Rate> getRates() {
		return rates;
	}

	public void setRates(List<Rate> rates) {
		this.rates = rates;
	}

	public List<Suggestion> getSuggestions() {
		return suggestions;
	}

	public void setSuggestions(List<Suggestion> suggestions) {
		this.suggestions = suggestions;
	}

}
