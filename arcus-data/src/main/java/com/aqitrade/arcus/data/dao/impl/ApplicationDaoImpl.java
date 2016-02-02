package com.aqitrade.arcus.data.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.aqitrade.arcus.data.dao.ApplicationDao;
import com.aqitrade.arcus.data.entity.ApplicationEntity;

@Repository
public class ApplicationDaoImpl extends GenericDaoImpl<ApplicationEntity, Integer>
    implements ApplicationDao {

  public ApplicationDaoImpl() {
    super(ApplicationEntity.class);
  }

  public List<ApplicationEntity> getAllOrderByDisplayOrder() {
    List<ApplicationEntity> list = getEntityManager()
        .createQuery("SELECT x FROM ApplicationEntity x order by x.applicationGroup.displayOrder",
            ApplicationEntity.class)
        .setHint("org.hibernate.cacheable", "true").getResultList();
    return list;

  }

  public List<ApplicationEntity> getAllApplicationsByGroupId(Integer applicationGroupId) {
    List<ApplicationEntity> list = getEntityManager()
        .createQuery("SELECT x FROM ApplicationEntity x where x.applicationGroupId=:groupId",
            ApplicationEntity.class)
        .setParameter("groupId", applicationGroupId).setHint("org.hibernate.cacheable", "true")
        .getResultList();
    return list;
  }

}
