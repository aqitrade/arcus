package com.aqitrade.arcus.data.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aqitrade.arcus.core.exception.ServiceException;
import com.aqitrade.arcus.core.util.CoreConstants;
import com.aqitrade.arcus.data.dao.GenericDao;

public class GenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK> {

  private final Logger log = LoggerFactory.getLogger(getClass());

  /**
   * Entity manager, injected by Spring using @PersistenceContext annotation on setEntityManager()
   */
  @PersistenceContext(unitName = CoreConstants.PERSISTENCE_UNIT_NAME)
  private EntityManager entityManager;
  private final Class<T> persistentClass;

  /**
   * Constructor that takes in a class to see which type of entity to persist. Use this constructor
   * when subclassing or using dependency injection.
   *
   * @param persistentClass the class type you'd like to persist
   */
  public GenericDaoImpl(final Class<T> persistentClass) {
    this.persistentClass = persistentClass;
  }

  /**
   * Returns JPA {@link EntityManager}
   *
   * @return {@link EntityManager}
   */
  public EntityManager getEntityManager() {
    return this.entityManager;
  }

  /**
   * {@inheritDoc}
   */
  public List<T> getListByCriteriaQuery(CriteriaQuery<T> query) {
    return this.entityManager.createQuery(query).getResultList();
  }

  /**
   * {@inheritDoc}
   */
  public List<T> getListByQuery(String query) {
    return this.entityManager.createQuery(query, getPersistentClass()).getResultList();
  }

  /**
   * {@inheritDoc}
   */
  public List<T> getListByQuery(String query, Map<String, Object> parameters) {
    TypedQuery<T> typedQuery = this.entityManager.createQuery(query, getPersistentClass());
    for (Entry<String, Object> entry : parameters.entrySet()) {
      typedQuery.setParameter(entry.getKey(), entry.getValue());
    }
    return typedQuery.getResultList();
  }

  /**
   * {@inheritDoc}
   */
  public List<T> getListByQuery(String query, Map<String, Object> parameters, boolean cacheable) {
    TypedQuery<T> typedQuery = this.entityManager.createQuery(query, getPersistentClass());
    for (Entry<String, Object> entry : parameters.entrySet()) {
      typedQuery.setParameter(entry.getKey(), entry.getValue());
    }
    typedQuery.setHint("org.hibernate.cacheable", cacheable);
    return typedQuery.getResultList();
  }

  /**
   * {@inheritDoc}
   */
  public List<T> getListByQuery(String query, boolean cacheable) {
    return this.entityManager.createQuery(query, getPersistentClass())
        .setHint("org.hibernate.cacheable", cacheable).getResultList();
  }


  /**
   * {@inheritDoc}
   */
  public List<T> getListByNamedQuery(String queryName) {
    return this.entityManager.createNamedQuery(queryName, getPersistentClass()).getResultList();
  }

  /**
   * {@inheritDoc}
   */
  @SuppressWarnings("unchecked")
  public List<T> getAll() {
    return this.entityManager
        .createQuery("select obj from " + this.persistentClass.getName() + " obj").getResultList();
  }

  /**
   * {@inheritDoc}
   */
  @SuppressWarnings({"unchecked", "rawtypes"})
  public List<T> getAllDistinct() {
    return this.entityManager
        .createQuery("select DISTINCT obj from " + this.persistentClass.getName() + " obj")
        .getResultList();
  }

  /**
   * {@inheritDoc}
   */
  public T get(PK id) {
    final T entity = this.entityManager.find(this.persistentClass, id);

    if (entity == null) {
      throw new ServiceException.EntityNotFoundException("Entity with id '" + id + "' not found");
    }

    return entity;
  }

  /**
   * {@inheritDoc}
   */
  public boolean exists(PK id) {
    final T entity = this.entityManager.find(this.persistentClass, id);
    return entity != null;
  }

  /**
   * {@inheritDoc}
   */
  public T save(T object) {
    return this.entityManager.merge(object);
  }

  /**
   * {@inheritDoc}
   */
  public void remove(T object) {
    entityManager.remove(entityManager.contains(object) ? object : entityManager.merge(object));
  }

  /**
   * {@inheritDoc}
   */
  public void remove(PK id) {
    this.entityManager.remove(this.get(id));
  }

  /**
   * @return the persistentClass
   */
  public Class<T> getPersistentClass() {
    return persistentClass;
  }

}
