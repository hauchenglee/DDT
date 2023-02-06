//package com.sample.ddt;
//
//import org.junit.Before;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.mock.web.MockHttpServletResponse;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
///**
// * https://www.bezkoder.com/spring-boot-webmvctest/
// * https://www.javaguides.net/2022/03/spring-boot-unit-testing-crud-rest-api-with-junit-and-mockito.html
// */
//@RunWith(SpringJUnit4ClassRunner.class)
////@SpringBootTest(classes = DdtApplication.class)
////@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@SpringBootTest
//@AutoConfigureMockMvc
//public class ApiTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    @Order(1)
//    @Rollback(value = false)
//    public void saveMoneyTest() throws Exception {
//        String url1 = "/api/money/getAndSaveMoneyApi"; // ok
//        String url2 = "http://127.0.0.1:8080/api/money/getAndSaveMoneyApi"; // ok
//        String url3 = "https://api.coindesk.com/v1/bpi/currentprice.json"; // error
//
//        mockMvc.perform(get(url1)).andExpect(status().isOk()).andDo(print());
//    }
//
//}
