package app.dao.impl;

import java.util.List;
import app.dao.GenericDAO;
import app.dao.ProductDAO;
import app.model.Product;

public class ProductDAOImpl extends GenericDAO<Integer, Product> implements ProductDAO {
	
	public ProductDAOImpl() {
		super(Product.class);
	}

	@Override
	public List<Product> loadProducts(String productName, int size, int page) {
		return (List<Product>) getSession().createQuery("from Product where name like :productName")
				.setString("productName", "%"+productName+"%")
				.setFirstResult(page*size)
				.setMaxResults(size)
				.getResultList();
	}

	@Override
	public int productCount() {
		return Integer.parseInt(getSession().createQuery("SELECT COUNT(*) FROM Product").getSingleResult().toString());
	}
	
}
