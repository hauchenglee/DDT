package com.sample.ddt.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import java.util.HashMap;
import java.util.Map;

@Configurable
@Import(SpringWebMvcConfigurer.class)
@PropertySource({"classpath:application.properties"})
public class SpringConfiguration {
}
