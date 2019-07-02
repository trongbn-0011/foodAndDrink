package app.dao;

import java.util.List;
import app.model.Product;

public interface ProductDAO extends BaseDAO<Integer, Product> {
	
	List<Product> loadProducts(int categoryId, String productName, int orderBy, int size, int page);
	
	int productCount(String productName);
	
}
