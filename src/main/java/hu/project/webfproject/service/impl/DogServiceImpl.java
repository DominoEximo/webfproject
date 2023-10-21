package hu.project.webfproject.service.impl;

import hu.project.webfproject.dto.DogDTO;
import hu.project.webfproject.entities.Dog;
import hu.project.webfproject.repository.DogRepository;
import hu.project.webfproject.service.DogService;
import hu.project.webfproject.utils.DogMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DogServiceImpl implements DogService {

    @Autowired
    DogRepository dogRepository;

    @Autowired
    DogMapper dogMapper;

    @Override
    public List<DogDTO> getAllDogs() {
        List<Dog> dogs = dogRepository.findAll();
        List<DogDTO> dtos = new ArrayList<>();
        dtos = dogMapper.DogListToDogDtoList(dogs);

        return dtos;

    }

    @Override
    public void saveDog(DogDTO dog) {
        Dog newDog = dogMapper.DogDtoToDog(dog);
        dogRepository.save(newDog);
    }

    @Override
    public void deleteDog(DogDTO dog) {
        dogRepository.deleteById(dog.getDogDtoId());
    }
}
