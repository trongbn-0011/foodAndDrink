package app.dao.impl;

import app.dao.GenericDAO;
import app.dao.ProductDAO;
import app.model.Product;

public class ProductDAOImpl extends GenericDAO<Integer, Product> implements ProductDAO {
	
	public ProductDAOImpl() {
		super(Product.class);
	}
	
}
