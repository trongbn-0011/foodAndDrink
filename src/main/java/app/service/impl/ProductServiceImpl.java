package app.service.impl;

import java.io.Serializable;

import app.model.Product;
import app.service.ProductService;

public class ProductServiceImpl extends BaseServiceImpl implements ProductService {

	@Override
	public Product findById(Serializable key) {
		// TODO Auto-generated method stub
		return getProductDAO().findById(key);
	}

	@Override
	public Product saveOrUpdate(Product entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Product entity) {
		// TODO Auto-generated method stub
		return false;
	}

}
