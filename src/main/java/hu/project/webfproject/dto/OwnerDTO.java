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
}
