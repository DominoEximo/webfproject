package hu.project.webfproject.dto;


import hu.project.webfproject.entities.Owner;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

import java.io.Serializable;

@Data
public class DogDTO implements Serializable {

    private Long dogDtoId;

    private String dogName;

    private Character dogGender;

    private String dogBreed;

    private Owner dogOwner;


    public Long getDogDtoId() {
        return dogDtoId;
    }

    public void setDogDtoId(Long dogId) {
        this.dogDtoId = dogId;
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public Character getDogGender() {
        return dogGender;
    }

    public void setDogGender(Character dogGender) {
        this.dogGender = dogGender;
    }

    public String getDogBreed() {
        return dogBreed;
    }

    public void setDogBreed(String dogBreed) {
        this.dogBreed = dogBreed;
    }

    public Owner getDogOwner() {
        return dogOwner;
    }

    public void setDogOwner(Owner dogOwner) {
        this.dogOwner = dogOwner;
    }
}
