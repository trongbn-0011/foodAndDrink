package app.dao.impl;

import java.util.List;
import org.hibernate.query.Query;
import app.dao.GenericDAO;
import app.dao.ProductDAO;
import app.model.Product;

public class ProductDAOImpl extends GenericDAO<Integer, Product> implements ProductDAO {
	
	public ProductDAOImpl() {
		super(Product.class);
	}

	@Override
	public List<Product> loadProducts(int categoryId, String productName, int orderBy, int size, int page) {
		String queryString = "from Product where (name like :productName)";
		if(categoryId != 0) queryString += " and (categoryid like :categoryId)";
		queryString += (orderBy == 0) ? " order by price asc" : " order by price desc";

		Query<Product> query = getSession().createQuery(queryString, Product.class);
		
		if(categoryId != 0) query.setParameter("categoryId", categoryId);
		
		query.setParameter("productName", "%"+productName+"%").setFirstResult(page*size).setMaxResults(size);
		
		return query.getResultList();
	}

	@Override
	public int productCount(String productName) {
		return Integer.parseInt(getSession().createQuery("SELECT COUNT(*) FROM Product where name like :productName")
				.setString("productName", "%"+productName+"%")
				.getSingleResult().toString());
	}
	
}
