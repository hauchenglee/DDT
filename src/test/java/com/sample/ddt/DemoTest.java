//package com.sample.ddt;
//
//import com.sample.ddt.dao.DemoDao;
//import com.sample.ddt.model.Demo;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.test.annotation.Rollback;
//
//import java.util.List;
//import java.util.Optional;
//
///**
// * https://www.javaguides.net/2021/07/crud-junit-tests-for-spring-data-jpa.html
// * https://www.bezkoder.com/spring-boot-unit-test-jpa-repo-datajpatest/
// */
//@DataJpaTest
//@WebMvcTest
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//public class DemoTest {
//    @Autowired
//    private DemoDao demoDao;
//
//    // JUnit test for saveDemo
//    @Test
//    @Order(1)
//    @Rollback(value = false)
//    public void saveDemoTest() {
//
//        Demo demo = new Demo();
//        demo.setId("1");
//        demo.setName("aaa");
//
//        demoDao.save(demo);
//
//        Assertions.assertThat(demo.getName()).isEqualTo("aaa");
//    }
//
//    @Test
//    @Order(2)
//    public void getDemoTest() {
//        Demo demo = demoDao.findById("1").get();
//        Assertions.assertThat(demo.getId()).isEqualTo("1");
//    }
//
//    @Test
//    @Order(3)
//    public void getListOfDemosTest() {
//        List<Demo> demos = demoDao.findAll();
//        Assertions.assertThat(demos.size()).isGreaterThan(0);
//    }
//
//    @Test
//    @Order(4)
//    @Rollback(value = false)
//    public void updateDemoTest() {
//        Demo demo = demoDao.findById("1").get();
//        demo.setName("bbb");
//        Demo demoUpdated = demoDao.save(demo);
//        Assertions.assertThat(demoUpdated.getName()).isEqualTo("bbb");
//    }
//
//    @Test
//    @Order(5)
//    @Rollback(value = false)
//    public void deleteDemoTest() {
//
//        Demo demo = demoDao.findById("1").get();
//
//        demoDao.delete(demo);
//
//        //demoDao.deleteById(1L);
//
//        Demo demo1 = null;
//        Optional<Demo> optionalDemo = demoDao.findById("1");
//        if (optionalDemo.isPresent()) {
//            demo1 = optionalDemo.get();
//        }
//
//        Assertions.assertThat(demo1).isNull();
//    }
//}
