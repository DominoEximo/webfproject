package hu.project.webfproject.dto;


import hu.project.webfproject.entities.Owner;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

import java.io.Serializable;

@Data
public class DogDTO implements Serializable {

    private Long id;

    private String name;

    private Character gender;

    private String breed;

    private OwnerDTO owner;


}
