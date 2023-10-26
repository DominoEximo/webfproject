package hu.project.webfproject.service.impl;

import hu.project.webfproject.dto.DogDTO;
import hu.project.webfproject.dto.OwnerDTO;
import hu.project.webfproject.entities.Dog;
import hu.project.webfproject.entities.Owner;
import hu.project.webfproject.repository.DogRepository;
import hu.project.webfproject.repository.OwnerRepository;
import hu.project.webfproject.service.DogService;
import hu.project.webfproject.utils.DogMapper;
import lombok.Data;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.faces.application.FacesMessage;
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
    public void saveDog(DogDTO dogToBeSaved) {
        Optional<Owner> tempOwner = ownerRepository.findById(dogToBeSaved.getDogOwner().getId());
        if(dogToBeSaved.getDogDtoId() == null){
            Dog newDog = dogMapper.DogDtoToDog(dogToBeSaved);
            if(tempOwner.isPresent()){
                Owner owner = tempOwner.get();
                newDog.setOwner(owner);
                dogRepository.save(newDog);
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, String.format("Owner notice %s",dogToBeSaved.getDogDtoId() ), "Succesfully added new Dog!");
                PrimeFaces.current().dialog().showMessageDynamic(message);
            }else{
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Owner notice", "Owner with the given ID does not exist!");
                PrimeFaces.current().dialog().showMessageDynamic(message);
            }
        }else{
            Optional<Dog> doggo = dogRepository.findById(dogToBeSaved.getDogDtoId());
            Dog existingDog = doggo.get();
            if(tempOwner.isPresent()){
                existingDog.setOwner(dogToBeSaved.getDogOwner());
                existingDog.setName(dogToBeSaved.getDogName());
                existingDog.setBreed(dogToBeSaved.getDogBreed());
                existingDog.setGender(dogToBeSaved.getDogGender());
                dogRepository.save(existingDog);
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Owner notice", "Updated existing dog!");
                PrimeFaces.current().dialog().showMessageDynamic(message);
            }else{
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Owner notice", "Owner with the given ID does not exist!");
                PrimeFaces.current().dialog().showMessageDynamic(message);
            }


        }
    }

    @Override
    public void deleteDog(DogDTO dog) {
        dogRepository.deleteById(dog.getDogDtoId());
    }


}
