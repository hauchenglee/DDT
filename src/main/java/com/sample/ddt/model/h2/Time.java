package com.sample.ddt.model.h2;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sample.ddt.config.MultiDateJsonDeserializer;
import com.sample.ddt.config.MultiDateStdDeserializer;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
@DynamicUpdate
@DynamicInsert
public class Time {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

//    @JsonDeserialize(using = MultiDateJsonDeserializer.class)
    @JsonDeserialize(using = MultiDateStdDeserializer.class)
    private Date updated;

//    @JsonDeserialize(using = MultiDateJsonDeserializer.class)
    @JsonDeserialize(using = MultiDateStdDeserializer.class)
    private Date updatedISO;

//    @JsonDeserialize(using = MultiDateJsonDeserializer.class)
    @JsonDeserialize(using = MultiDateStdDeserializer.class)
    private Date updateduk;
}
