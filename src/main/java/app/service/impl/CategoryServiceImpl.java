package app.service.impl;

import java.io.Serializable;
import java.util.List;
import app.model.Category;
import app.service.CategoryService;

public class CategoryServiceImpl extends BaseServiceImpl implements CategoryService {

	@Override
	public Category findById(Serializable key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category saveOrUpdate(Category entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Category entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Category> loadSubCategories(int parentId) {
		return getCategoryDAO().loadSubCategories(parentId);
	}

	@Override
	public Category findByName(String categoryName) {
		return getCategoryDAO().findByName(categoryName);
	}

}
