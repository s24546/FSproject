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
}
