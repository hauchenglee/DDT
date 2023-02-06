package com.sample.ddt.model;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@DynamicUpdate
@DynamicInsert
public class Demo {
    @Id
    private String id;

    private String name;
}
