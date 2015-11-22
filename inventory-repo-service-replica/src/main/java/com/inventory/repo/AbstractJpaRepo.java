package com.inventory.repo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractJpaRepo<T> {

    private Class<T> clazz;

    @PersistenceContext
    protected EntityManager entityManager;

    public final void setClazz(final Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    public T findOne(final Integer id) {
        return entityManager.find(clazz, id);
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        return entityManager.createQuery("from " + clazz.getName()).getResultList();
    }
    
    @SuppressWarnings("unchecked")
    public List<T> findByQuery(String query) {
        return entityManager.createQuery(query).getResultList();
    }

    public void create(final T entity) {
    	entityManager.persist(entity);
    	entityManager.flush();
        //entityManager.merge(entity);
    }

    public T update(final T entity) {
        return entityManager.merge(entity);
    }

    public void delete(final T entity) {
        entityManager.remove(entity);
    }

    public void deleteById(final Integer entityId) {
        final T entity = findOne(entityId);
        delete(entity);
    }

}
