package hu.project.webfproject.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class DogDTO implements Serializable {

    private Long id;

    private String name;

    private String breed;


}
