package hu.project.webfproject.controller;

import hu.project.webfproject.dto.DogDTO;
import hu.project.webfproject.dto.OwnerDTO;
import hu.project.webfproject.entities.Dog;
import hu.project.webfproject.service.DogService;
import hu.project.webfproject.utils.DogMapper;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
@Data
public class DogController {

    @Autowired
    DogService dogService;

    @Autowired
    DogMapper dogMapper;

    List<DogDTO> dogs;

    List<OwnerDTO> owners;

    DogDTO dogDTO;

    OwnerDTO ownerDTO;


    @PostConstruct
    public void getAllDogs(){
        if(!this.getDogs().isEmpty()){
            this.getDogs().clear();
            this.getOwners().clear();
        }
        this.getDogs().addAll(dogService.getAllDogs());
    }
    public List<DogDTO> getDogs(){
        return null;
    }

    public void saveDog(DogDTO dogDTO){
        dogService.saveDog(dogDTO);
    }

}
