package com.projectabhishek.partyDetailService.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Data creates equals, hashcode, and toString methods
//@Entity makes this object ready for storage in a JPA based Entity store
@Data
@Entity
public class Party {

    private @Id
    @GeneratedValue
    Long id;
    private String name;
    private String region;
    private String status;
    private String type;

    Party() {
    }

    public Party(String name, String region, String status, String type) {
        this.name = name;
        this.region = region;
        this.status = status;
        this.type = type;
    }
}