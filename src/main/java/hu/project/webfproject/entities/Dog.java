package hu.project.webfproject.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "GENDER")
    private Character gender;

    @Column(name = "BREED")
    private String breed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OWNER_ID")
    private Owner ownerId;


}
