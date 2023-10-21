package hu.project.webfproject.service.impl;

import hu.project.webfproject.entities.Dog;
import hu.project.webfproject.repository.DogRepository;
import hu.project.webfproject.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogServiceImpl implements DogService {

    @Autowired
    DogRepository dogRepository;

    @Override
    public List<Dog> getAllDogs() {
        return dogRepository.findAll();
    }

    @Override
    public void saveDog(Dog dog) {
        dogRepository.save(dog);
    }

    @Override
    public void deleteDog(Dog dog) {
        dogRepository.delete(dog);
    }
}
