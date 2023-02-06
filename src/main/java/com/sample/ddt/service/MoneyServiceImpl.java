package com.sample.ddt.service;

import com.sample.ddt.dao.h2.MoneyDao;
import com.sample.ddt.model.h2.Money;
import com.sample.ddt.util.CoindeskAPI;
import com.sample.ddt.util.Constants;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Primary
public class MoneyServiceImpl implements MoneyService {

    @Autowired
    private MoneyDao moneyDao;

    @Override
    public Optional<Money> findById(Integer id) {
        return moneyDao.findById(id);
    }

    @Override
    public void save(Money money) {
        moneyDao.save(money);
    }

    @Override
    public void saveAndUpdate(Money money) {
        moneyDao.save(money);
    }

    @Override
    public Optional<Money> getMoneyAPI() {
        return CoindeskAPI.getMoneyAPI();
    }

    private static final Map<String, String> currency = new HashMap<>();

    @Bean
    public static void initCurrencyName() {
        currency.put("United States Dollar", "美元");
        currency.put("British Pound Sterling", "英鎊");
        currency.put("Euro", "歐元");
    }
}
