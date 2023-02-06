package com.sample.ddt.dao.h2;

import com.sample.ddt.model.h2.Money;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoneyDao extends JpaRepository<Money, Integer> {

}
