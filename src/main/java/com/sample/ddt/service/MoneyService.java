package com.sample.ddt.service;

import com.sample.ddt.model.h2.Money;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.Optional;

@Service
public interface MoneyService {

    Optional<Money> findById(Integer id);

    void save(Money money);

    void saveAndUpdate(Money money);

    Optional<Money> getMoneyAPI();
}
