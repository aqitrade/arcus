package com.aqitrade.arcus.data.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.aqitrade.arcus.core.exception.ServiceException;
import com.aqitrade.arcus.data.dao.GenericDao;

public class GenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK> {
  /**
   * Log variable for all child classes. Uses LogFactory.getLog(getClass()) from Commons Logging
   */
  protected final Log log = LogFactory.getLog(getClass());

  public static final String PERSISTENCE_UNIT_NAME = "mysql";

  /**
   * Entity manager, injected by Spring using @PersistenceContext annotation on setEntityManager()
   */
  @PersistenceContext(unitName = PERSISTENCE_UNIT_NAME)
  private EntityManager entityManager;
  private Class<T> persistentClass;

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
   * Constructor that takes in a class to see which type of entity to persist. Use this constructor
   * when subclassing or using dependency injection.
   * 
   * @param persistentClass the class type you'd like to persist
   * @param entityManager the configured EntityManager for JPA implementation.
   */
  public GenericDaoImpl(final Class<T> persistentClass, EntityManager entityManager) {
    this.persistentClass = persistentClass;
    this.entityManager = entityManager;
  }

  public EntityManager getEntityManager() {
    return this.entityManager;
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
    Collection result = new LinkedHashSet(getAll());
    return new ArrayList(result);
  }

  /**
   * {@inheritDoc}
   */
  public T get(PK id) {
    T entity = this.entityManager.find(this.persistentClass, id);

    if (entity == null) {
      throw new ServiceException.EntityNotFoundException("Entity with id '" + id + "' not found");
    }

    return entity;
  }

  /**
   * {@inheritDoc}
   */
  public boolean exists(PK id) {
    T entity = this.entityManager.find(this.persistentClass, id);
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

}
