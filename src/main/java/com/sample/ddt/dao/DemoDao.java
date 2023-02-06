package com.sample.ddt.dao;

import com.sample.ddt.model.Demo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoDao extends JpaRepository<Demo, String> {
}
