package app.service.impl;

import app.dao.ProductDAO;
import app.dao.UserDAO;

public class BaseServiceImpl {
	
	protected ProductDAO productDAO;
	protected UserDAO userDAO;

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
	
}
