package app.dao.impl;

import java.util.List;
import app.dao.CategoryDAO;
import app.dao.GenericDAO;
import app.model.Category;

public class CategoryDAOImpl extends GenericDAO<Integer, Category> implements CategoryDAO {

	@Override
	public List<Category> loadSubCategories(int parentId) {
		return (List<Category>) getSession().createQuery("from Category where parentid = :parentId")
				.setInteger("parentId", parentId)
				.getResultList();
	}

	@Override
	public Category findByName(String categoryName) {
		return (Category) getSession().createQuery("from Category where name= :categoryName")
				.setString("categoryName", categoryName)
				.getSingleResult();
	} 

}
