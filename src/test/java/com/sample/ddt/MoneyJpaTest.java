package com.sample.ddt;

import com.sample.ddt.dao.h2.MoneyDao;
import com.sample.ddt.model.h2.Money;
import com.sample.ddt.model.h2.Time;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

/**
 * https://www.javaguides.net/2021/07/crud-junit-tests-for-spring-data-jpa.html
 * https://www.bezkoder.com/spring-boot-unit-test-jpa-repo-datajpatest/
 */
@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MoneyJpaTest {

    @Autowired
    private MoneyDao moneyDao;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void setup() throws Exception {
        Integer id = 1;

        Money money = new Money();
        money.setId(id);
        money.setChartName("Bitcoin");

        String stringDate1 = "Feb 2, 2023 11:34:00 UTC";
        String stringDate2 = "2023-02-02T11:34:00+00:00";
        String stringDate3 = "Feb 2, 2023 at 11:34 GMT".replaceAll("at", "");

        SimpleDateFormat sdf1 = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss 'UTC'", Locale.ENGLISH);
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        SimpleDateFormat sdf3 = new SimpleDateFormat("MMM dd, yyyy HH:mm 'GMT'", Locale.ENGLISH);

        Date date1 = sdf1.parse(stringDate1);
        Date date2 = sdf2.parse(stringDate2);
        Date date3 = sdf3.parse(stringDate3);
        Time time = new Time();
        time.setUpdated(date1);
        time.setUpdatedISO(date2);
        time.setUpdateduk(date3);

        money.setTime(time);
        moneyDao.save(money);

        Assertions.assertThat(money.getChartName()).isEqualTo("Bitcoin");
    }

    @Test
    @Order(2)
    public void getMoneyTest() {
        Money money = moneyDao.findById(1).get();
        Assertions.assertThat(money.getId()).isEqualTo(1);
    }

    @Test
    @Order(3)
    public void getListOfMoneysTest() {
        List<Money> moneys = moneyDao.findAll();
        Assertions.assertThat(moneys.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateMoneyTest() throws ParseException {
        Money money = moneyDao.findById(1).get();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date updateDate = sdf.parse("1990/01/01 00:00:00");
        if (money.getTime() == null) {
            System.out.println("is null aaaaaaaaa");
        } else {
            money.getTime().setUpdated(updateDate);
            Money moneyUpdated = moneyDao.save(money);
            Assertions.assertThat(moneyUpdated.getTime().getUpdated()).isEqualTo(updateDate);
        }
    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteMoneyTest() {

        Money money = moneyDao.findById(1).get();

        moneyDao.delete(money);

        //moneyDao.deleteById(1L);

        Money money1 = null;
        Optional<Money> optionalMoney = moneyDao.findById(1);
        if (optionalMoney.isPresent()) {
            money1 = optionalMoney.get();
        }

        Assertions.assertThat(money1).isNull();
    }
}
