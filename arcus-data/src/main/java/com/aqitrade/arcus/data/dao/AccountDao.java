package com.aqitrade.arcus.data.dao;

import java.util.List;

import com.aqitrade.arcus.data.entity.AccountEntity;

public interface AccountDao extends GenericDao<AccountEntity, Integer> {
  List<AccountEntity> getAccountsByPortfolioId(Integer portfolioId);

  List<AccountEntity> getAccountsByPortfolioIdAndBrokerId(Integer portfolioId, Integer brokerId);
}
