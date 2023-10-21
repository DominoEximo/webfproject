package hu.project.webfproject.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class OwnerDTO implements Serializable {

    private Long id;

    private String name;
}
