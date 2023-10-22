package hu.project.webfproject.service.impl;

import hu.project.webfproject.dto.DogDTO;
import hu.project.webfproject.entities.Dog;
import hu.project.webfproject.entities.Owner;
import hu.project.webfproject.repository.DogRepository;
import hu.project.webfproject.repository.OwnerRepository;
import hu.project.webfproject.service.DogService;
import hu.project.webfproject.utils.DogMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DogServiceImpl implements DogService {

    @Autowired
    DogRepository dogRepository;

    @Autowired
    OwnerRepository ownerRepository;

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
        try{
            Optional<Owner> tempOwner = ownerRepository.findById(dog.getDogOwner().getId());
            Dog newDog = dogMapper.DogDtoToDog(dog);
            if(tempOwner.isPresent()){
                Owner owner = tempOwner.get();
                newDog.setOwner(owner);
            }

            dogRepository.save(newDog);
        }catch (RuntimeException e){
            throw new RuntimeException("exception!",e.getCause());
        }

    }

    @Override
    public void deleteDog(DogDTO dog) {
        dogRepository.deleteById(dog.getDogDtoId());
    }

    @Override
    public void updateDog(DogDTO dog) {
        Optional<Dog> doggo = dogRepository.findById(dog.getDogDtoId());

        if (doggo.isPresent()){
            Dog _dog = doggo.get();
            _dog.setGender(doggo.get().getGender());
            _dog.setBreed(doggo.get().getBreed());
            _dog.setOwner(doggo.get().getOwner());
            _dog.setName(doggo.get().getName());
        }
    }
}
