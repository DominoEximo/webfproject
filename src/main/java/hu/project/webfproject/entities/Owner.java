package hu.project.webfproject.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "GENDER")
    private Character gender;

    @Column(name = "AGE")
    private Integer age;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "DOG_ID")
    private List<Dog> dogs;
}
