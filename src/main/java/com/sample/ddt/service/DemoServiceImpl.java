package com.sample.ddt.service;


import com.sample.ddt.dao.DemoDao;
import com.sample.ddt.model.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Primary
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoDao demoDao;

    @Override
    public Optional<Demo> findById(String id) {
        return demoDao.findById(id);
    }

    @Override
    public void save(Demo demo) {
        demoDao.save(demo);
    }
}
