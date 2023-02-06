package com.sample.ddt.service;


import com.sample.ddt.model.Demo;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface DemoService {

    Optional<Demo> findById(String id);

    void save(Demo demo);
}
