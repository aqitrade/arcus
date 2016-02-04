package com.aqitrade.arcus.data.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.aqitrade.arcus.data.dao.AccountDao;
import com.aqitrade.arcus.data.entity.AccountEntity;

@Repository
public class AccountDaoImpl extends GenericDaoImpl<AccountEntity, Integer> implements AccountDao {

  public AccountDaoImpl() {
    super(AccountEntity.class);
  }

  public List<AccountEntity> getAccountsByPortfolioId(Integer portfolioId) {
    Map<String, Object> parameters = new HashMap<String, Object>();
    parameters.put("portfolioId", portfolioId);
    return getListByQuery("from AccountEntity x where x.portfolioId=:portfolioId", parameters);
  }

  public List<AccountEntity> getAccountsByPortfolioIdAndBrokerId(Integer portfolioId,
      Integer brokerId) {
    Map<String, Object> parameters = new HashMap<String, Object>();
    parameters.put("portfolioId", portfolioId);
    parameters.put("brokerId", brokerId);
    return getListByQuery(
        "from AccountEntity x where x.portfolioId=:portfolioId and x.brokerId=:brokerId",
        parameters);
  }

}
