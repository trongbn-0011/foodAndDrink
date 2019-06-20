package app.dao;

import java.io.Serializable;

public interface BaseDAO<PK, T> {

	public void delete(T entity);

	public T saveOrUpdate(T entity);

	public T findById(Serializable key);
}
