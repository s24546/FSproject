package com.fs.client.contracts;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class EpisodeDto {
    public Long id;
    public String name;
    @JsonProperty("air_date")
    public String airDate;
    public String director;
    public String writer;
    @JsonProperty("img_url")
    public String imgUrl;

    @Override
    public String toString() {
        return "EpisodeDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", airDate='" + airDate + '\'' +
                ", director='" + director + '\'' +
                ", writer='" + writer + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
