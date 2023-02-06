package com.sample.ddt.model.h2;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Data
@Entity
@DynamicUpdate
@DynamicInsert
public class BPI {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne(cascade = {CascadeType.ALL})
    @JsonProperty("USD")
    private MoneyDetail usd;

    @OneToOne(cascade = {CascadeType.ALL})
    @JsonProperty("GBP")
    private MoneyDetail gbp;

    @OneToOne(cascade = {CascadeType.ALL})
    @JsonProperty("EUR")
    private MoneyDetail eur;
}
