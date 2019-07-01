package app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import app.model.Product;

public interface ProductService extends BaseService<Integer, Product> {
	
	Page<Product> loadProducts(int categoryId, String productName, int orderBy, Pageable pageable);
	
	int productCount(String productName);
	
}
