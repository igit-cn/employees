package lt.employees.domain.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lt.employees.domain.entity.AbstractEntity;

/**
 * Abstract JPA Dao class.
 */
public abstract class AbstractJpaDAO<T extends AbstractEntity> {

	private Class<T> clazz;

	@PersistenceContext
	private EntityManager entityManager;

	public final void setClazz(Class<T> clazzToSet) {
		this.clazz = clazzToSet;
	}

	public T findById(long id) {
		return entityManager.find(clazz, id);
	}

	public List<T> findAll() {
		return entityManager.createQuery("from " + clazz.getName()).getResultList();
	}

	public void saveOrUpdate(T entity) {
		if (entity.getId() == null) {
			entityManager.persist(entity);
		} else {
			entityManager.merge(entity);
		}
	}

	public void create(T entity) {
		entityManager.persist(entity);
	}

	public T update(T entity) {
		return entityManager.merge(entity);
	}

	public void delete(T entity) {
		entityManager.remove(entity);
	}

	public void deleteById(long entityId) {
		T entity = findById(entityId);
		delete(entity);
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
}
