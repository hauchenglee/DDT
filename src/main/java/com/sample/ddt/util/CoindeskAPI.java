package com.sample.ddt.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.ddt.model.h2.Money;
import lombok.SneakyThrows;

import java.util.Optional;

public class CoindeskAPI {

    @SneakyThrows
    public static Optional<Money> getMoneyAPI() {
        String url = Constants.coindeskAPI;
        Money money;

        String context = HttpRequestUtils.sendGet(url);
        ObjectMapper mapper = new ObjectMapper();
        money = mapper.readValue(context, Money.class);
        return Optional.of(money);
    }
}
