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

    public String getAirDate() {
        return airDate;
    }

    public void setAirDate(String airDate) {
        this.airDate = airDate;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
