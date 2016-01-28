package com.aqitrade.arcus.data.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

public interface GenericDao<T, PK extends Serializable> {

  /**
   * Generic method used to get all objects of a particular type. This is the same as lookup up all
   * rows in a table.
   *
   * @return List of populated objects
   */
  List<T> getAll();

  /**
   * Gets all records without duplicates.
   * <p>
   * Note that if you use this method, it is imperative that your model classes correctly implement
   * the hashcode/equals methods
   * </p>
   *
   * @return List of populated objects
   */
  List<T> getAllDistinct();

  /**
   * Generic method to get an object based on class and identifier. An
   * ObjectRetrievalFailureException Runtime Exception is thrown if nothing is found.
   *
   * @param id the identifier (primary key) of the object to get
   * @return a populated object
   * @see org.springframework.orm.ObjectRetrievalFailureException
   */
  T get(PK id);

  /**
   * Checks for existence of an object of type T using the id arg.
   *
   * @param id the id of the entity
   * @return - true if it exists, false if it doesn't
   */
  boolean exists(PK id);

  /**
   * Generic method to save an object - handles both update and insert.
   *
   * @param object the object to save
   * @return the persisted object
   */
  T save(T object);

  /**
   * Generic method to delete an object
   *
   * @param object the object to remove
   */
  void remove(T object);

  /**
   * Generic method to delete an object
   *
   * @param id the identifier (primary key) of the object to remove
   */
  void remove(PK id);

  /**
   * Returns list of Entities for the given {@link CriteriaQuery}
   *
   * @param query {@link CriteriaQuery}
   * @return List List of entities
   */
  List<T> getListByCriteriaQuery(CriteriaQuery<T> query);

  /**
   * Returns list of entities for the given JPA query
   *
   * @param query Query
   * @return List list of entities
   */
  List<T> getListByQuery(String query);

  /**
   * Returns list of entities for the given JPA named query
   *
   * @param queryName named query name
   * @return List list of entities
   */
  List<T> getListByNamedQuery(String queryName);

}
