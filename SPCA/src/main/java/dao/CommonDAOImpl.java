package dao;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
public abstract class CommonDAOImpl<T, ID extends Serializable> implements CommonDAO<T, ID> {
	
	private EntityManager em;
	
	private Class<T> entityClass;
	
	public CommonDAOImpl(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
	
	@Override
	public T findByID(int id) {
		// TODO Auto-generated method stub
		return em.find(entityClass, id);
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		TypedQuery<T> query = em.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e", entityClass);
		return query.getResultList();
	}

	@Override
	public void save(T object) {
		// TODO Auto-generated method stub
		em.persist(object);
	}

	@Override
	public T update(T object) {
		// TODO Auto-generated method stub
		return em.merge(object);
	}

	@Override
	public void delete(T object) {
		// TODO Auto-generated method stub
		em.remove(em.contains(object) ? object : em.merge(object));
	}
}