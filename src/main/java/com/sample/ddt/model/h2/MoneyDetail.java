package com.sample.ddt.model.h2;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@DynamicUpdate
@DynamicInsert
public class MoneyDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String code;
    private String symbol;
    private String rate;
    private String description;

    @JsonIgnore
    private String description_cn;
    private Float rate_float;
}
