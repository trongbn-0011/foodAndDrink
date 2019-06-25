package app.service.impl;

import app.dao.ProductDAO;

public class BaseServiceImpl {
	
	protected ProductDAO productDAO;

	public ProductDAO getProductDAO() {
		return productDAO;
	}

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	
}
