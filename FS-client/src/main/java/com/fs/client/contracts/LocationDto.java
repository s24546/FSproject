package com.fs.client.contracts;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LocationDto {
    public Long id;
    public String name;
    public String type;
    @JsonProperty("img_url")
    public String imgUrl;

    @Override
    public String toString() {
        return "LocationDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
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
