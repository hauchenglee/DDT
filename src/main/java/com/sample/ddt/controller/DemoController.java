package com.sample.ddt.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.ddt.model.Demo;
import com.sample.ddt.model.ResultBean;
import com.sample.ddt.model.ResultCode;
import com.sample.ddt.service.DemoService;
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
public class DemoController {

    int errorCode = ResultCode.Exception.getCode();
    String errorMsg = ResultCode.Exception.getMessage();

    @Autowired
    private DemoService demoService;

    @GetMapping(value = "/", produces = Constants.CONTENT_TYPE_JSON)
    public String home() {
        return "hello world";
    }

    @GetMapping(value = "/demo", produces = Constants.CONTENT_TYPE_JSON)
    public String demo(HttpServletRequest request, @RequestBody String receiveJSON) {
        int result = 2;
        return "{\"aaa\": \"" + result + "\"}";
    }

    @GetMapping(value = "/demo/error", produces = Constants.CONTENT_TYPE_JSON)
    public ResultBean<String> error(HttpServletRequest request, @RequestBody String receiveJSON) {
        return ResultBean.error(errorCode, errorMsg);
    }

    @GetMapping(value = "/demo/findById", produces = Constants.CONTENT_TYPE_JSON)
    public ResultBean<Demo> findById(HttpServletRequest request, @RequestBody String receiveJSON) throws JsonProcessingException {
        System.out.println(receiveJSON);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(receiveJSON);
        String id = jsonNode.get("id").asText();
        Optional<Demo> demo = demoService.findById(id);
        return ResultBean.success(demo);
    }

    @SneakyThrows
    @PostMapping(value = "/demo/addDemo", produces = Constants.CONTENT_TYPE_JSON)
    public ResultBean<Boolean> addDemo(HttpServletRequest request, @RequestBody String receiveJSON) {
        System.out.println(receiveJSON);
        ObjectMapper mapper = new ObjectMapper();
        Demo demo = mapper.readValue(receiveJSON, Demo.class);
        demoService.save(demo);
        return ResultBean.success(true);
    }
}
