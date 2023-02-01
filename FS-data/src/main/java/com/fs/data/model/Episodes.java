package com.fs.data.model;

import com.fs.client.contracts.EpisodeDto;
import jakarta.persistence.*;


@Entity
@Table
public class Episodes {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String name;
    private String airDate;
    private String director;
    private String writer;
    private String imgUrl;

    public Episodes(String name, String airDate, String director, String writer, String imgUrl) {
        this.name = name;
        this.airDate = airDate;
        this.director = director;
        this.writer = writer;
        this.imgUrl = imgUrl;
    }

    public Episodes() {
    }

    public Episodes(EpisodeDto episodeDto) {
    }

//    public Episodes update(Episodes episode) {
//        if (!episode.name.isEmpty()) {
//            this.name = episode.name;
//        }
//        if (!episode.airDate.isEmpty()) {
//            this.airDate = episode.airDate;
//        }
//        if (!episode.director.isEmpty()) {
//            this.director = episode.director;
//        }
//        if (!episode.writer.isEmpty()) {
//            this.writer = episode.writer;
//        }
//        if (!episode.imgUrl.isEmpty()) {
//            this.imgUrl = episode.imgUrl;
//        }
//        return this;
//    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}


