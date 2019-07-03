package app.service.impl;

import app.dao.CategoryDAO;
import app.dao.ProductDAO;
import app.dao.UserDAO;

public class BaseServiceImpl {
	
	protected ProductDAO productDAO;
	protected UserDAO userDAO;
	protected CategoryDAO categoryDAO;
	
	public ProductDAO getProductDAO() {
		return productDAO;
	}

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public CategoryDAO getCategoryDAO() {
		return categoryDAO;
	}

	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}
	
}
