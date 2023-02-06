package com.sample.ddt.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.ddt.model.ResultBean;
import com.sample.ddt.model.ResultCode;
import com.sample.ddt.model.h2.Money;
import com.sample.ddt.service.MoneyService;
import com.sample.ddt.util.Constants;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
public class MoneyController {

    int errorCode = ResultCode.Exception.getCode();
    String errorMsg = ResultCode.Exception.getMessage();

    @Autowired
    private MoneyService moneyService;

    @GetMapping(value = "/api/money/error", produces = Constants.CONTENT_TYPE_JSON)
    public ResultBean<String> moneyError(HttpServletRequest request, @RequestBody String receiveJSON) {
        return ResultBean.error(errorCode, errorMsg);
    }

    @SneakyThrows
    @GetMapping(value = "/api/money/getMoneyApi", produces = Constants.CONTENT_TYPE_JSON)
    public ResultBean<Money> getMoneyApi() {
        Optional<Money> money = moneyService.getMoneyAPI();
        return ResultBean.success(money);
    }

    @SneakyThrows
    @GetMapping(value = "/api/money/getAndSaveMoneyApi", produces = Constants.CONTENT_TYPE_JSON)
    public ResultBean<Money> getAndSaveMoneyApi() {
        Optional<Money> money = moneyService.getMoneyAPI();
        money.ifPresent(value -> moneyService.save(value));
        return ResultBean.success(money);
    }

    @SneakyThrows
    @PostMapping(value = "/api/money/findById", produces = Constants.CONTENT_TYPE_JSON)
    public ResultBean<Money> findById(HttpServletRequest request, @RequestBody String receiveJSON) {
        System.out.println(receiveJSON);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(receiveJSON);
        Integer id = jsonNode.get("id").asInt();
        Optional<Money> money = moneyService.findById(id);
        return ResultBean.success(money);
    }

    @SneakyThrows
    @PostMapping(value = "/api/money/save", produces = Constants.CONTENT_TYPE_JSON)
    public ResultBean<Boolean> saveMoney(HttpServletRequest request, @RequestBody(required = false) String receiveJSON) {
        ObjectMapper mapper = new ObjectMapper();
        Money money = mapper.readValue(receiveJSON, Money.class);
        moneyService.save(money);
        return ResultBean.success(true);
    }
}
