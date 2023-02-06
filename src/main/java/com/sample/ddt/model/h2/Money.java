package com.sample.ddt.model.h2;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Data
@Entity
@DynamicUpdate
@DynamicInsert
public class Money {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = {CascadeType.ALL})
    private Time time;

    private String disclaimer;

    private String chartName;

    @OneToOne(cascade = {CascadeType.ALL})
    private BPI bpi;
}
