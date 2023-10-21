package hu.project.webfproject.service;


import hu.project.webfproject.entities.Dog;

import java.util.List;

public interface DogService {

    List<Dog> getAllDogs();

    void saveDog(Dog dog);

    void deleteDog(Dog dog);
}
