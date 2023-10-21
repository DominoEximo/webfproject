package hu.project.webfproject.service;


import hu.project.webfproject.dto.DogDTO;
import hu.project.webfproject.entities.Dog;

import java.util.List;

public interface DogService {

    List<DogDTO> getAllDogs();

    void saveDog(DogDTO dog);

    void deleteDog(DogDTO dog);
}
