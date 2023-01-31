package com.fs.data.model;

import com.fs.client.contracts.LocationDto;
import jakarta.persistence.*;


@Entity
@Table
public class Locations {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String name;
    private String type;
    private String imgUrl;

    public Locations(String name, String type, String imgUrl) {
        this.name = name;
        this.type = type;
        this.imgUrl = imgUrl;
    }

    public Locations() {
    }

    public Locations(LocationDto locationDto) {
    }

    public Locations update(Locations location) {
        if (!location.name.isEmpty()) {
            this.name = location.name;
        }
        if (!location.type.isEmpty()) {
            this.type = location.type;
        }
        if (!location.type.isEmpty()) {
            this.type = location.type;
        }
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}