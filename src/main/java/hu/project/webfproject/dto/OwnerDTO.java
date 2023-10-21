package hu.project.webfproject.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class OwnerDTO implements Serializable {

    private Long id;

    private String name;

    private Character gender;

    private Integer age;

    private List<DogDTO> dogs;

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

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<DogDTO> getDogs() {
        return dogs;
    }

    public void setDogs(List<DogDTO> dogs) {
        this.dogs = dogs;
    }
}
