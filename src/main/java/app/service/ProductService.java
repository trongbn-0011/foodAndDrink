package app.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import app.model.Product;

public interface ProductService extends BaseService<Integer, Product> {
	
	Page<Product> findPaginated(Pageable pageable);
	
	int productCount();
}
