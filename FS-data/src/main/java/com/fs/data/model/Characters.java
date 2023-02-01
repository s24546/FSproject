package com.fs.data.model;

import com.fs.client.contracts.CharacterDto;
import jakarta.persistence.*;


@Entity
@Table
public class Characters {

@GeneratedValue(strategy = GenerationType.IDENTITY)
@Id
private Long id;

private String name;
private String status;
private String species;
private String gender;
private String hair;
private String origin;
private String imgUrl;

    public Characters(String name, String status, String species, String gender, String hair, String origin, String imgUrl) {
        this.name = name;
        this.status = status;
        this.species = species;
        this.gender = gender;
        this.hair = hair;
        this.origin = origin;
        this.imgUrl = imgUrl;
    }

    public Characters(CharacterDto characterDto) {
    }

    public Characters() {
    }

//    public Characters update(Characters character) {
//        if (!character.name.isEmpty()) {
//            this.name = character.name;
//        }
//        if (!character.status.isEmpty()) {
//            this.status = character.status;
//        }
//        if (!character.species.isEmpty()) {
//            this.species = character.species;
//        }if (!character.gender.isEmpty()) {
//            this.gender = character.gender;
//        }if (!character.hair.isEmpty()) {
//            this.hair = character.hair;
//        }if (!character.origin.isEmpty()) {
//            this.origin = character.origin;
//        }if (!character.imgUrl.isEmpty()) {
//            this.imgUrl = character.imgUrl;
//        }
//        return this;
//    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHair() {
        return hair;
    }

    public void setHair(String hair) {
        this.hair = hair;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
