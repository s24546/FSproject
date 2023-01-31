package com.fs.client.contracts;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CharacterDto {
    public Long id;
    public String name;
    public String status;
    public String species;
    public String gender;
    public String hair;
    public String origin;
    @JsonProperty("img_url")
    public String imgUrl;

    @Override
    public String toString() {
        return "CharacterDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", species='" + species + '\'' +
                ", gender='" + gender + '\'' +
                ", hair='" + hair + '\'' +
                ", origin='" + origin + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}

