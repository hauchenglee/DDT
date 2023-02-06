package com.sample.ddt;

import com.sample.ddt.controller.DemoController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestingWebApplicationTests {

    @Autowired
    private DemoController controller;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

}
