package hu.project.webfproject.controller;

import hu.project.webfproject.dto.DogDTO;
import hu.project.webfproject.dto.OwnerDTO;
import hu.project.webfproject.entities.Dog;
import hu.project.webfproject.entities.Owner;
import hu.project.webfproject.service.DogService;
import hu.project.webfproject.utils.DogMapper;
import hu.project.webfproject.utils.OwnerMapper;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DogController {

    @Autowired
    private DogService dogService;

    @Autowired
    private DogMapper dogMapper;

    @Autowired
    private OwnerMapper ownerMapper;

    private String actionLabel;

    private List<DogDTO> dogs;

    private List<OwnerDTO> owners;

    private DogDTO dogDTO;

    private OwnerDTO ownerDTO;


    @PostConstruct
    public void getAllDogs(){
        if(!this.getDogs().isEmpty()){
            this.getDogs().clear();
            this.getOwners().clear();
        }
        this.getDogs().addAll(dogService.getAllDogs());
        this.setActionLabel("Add");
        getDogDTO();
        this.dogDTO.setDogDtoId(null);
    }

    public void saveDog(){
        Owner newOwner = ownerMapper.OwnerDtoToOwner(this.ownerDTO);
        dogDTO.setDogOwner(newOwner);
        dogService.saveDog(this.dogDTO);
        getAllDogs();
    }

    public void deleteDog(DogDTO tobeDeleted){
        dogService.deleteDog(tobeDeleted);
        getAllDogs();
    }

    public void updateDog(DogDTO toBeUpdated){
        setActionLabel("Update");
        dogDTO.setDogDtoId(toBeUpdated.getDogDtoId());
        dogDTO.setDogBreed(toBeUpdated.getDogBreed());
        dogDTO.setDogGender(toBeUpdated.getDogGender());
        dogDTO.setDogName(toBeUpdated.getDogName());
        dogDTO.setDogOwner(toBeUpdated.getDogOwner());
    }

    public DogService getDogService() {
        return dogService;
    }

    public void setDogService(DogService dogService) {
        this.dogService = dogService;
    }

    public DogMapper getDogMapper() {
        return dogMapper;
    }

    public void setDogMapper(DogMapper dogMapper) {
        this.dogMapper = dogMapper;
    }

    public List<DogDTO> getDogs(){
        if(null == dogs){
            dogs = new ArrayList<DogDTO>();
        }
        return dogs;
    }

    public List<OwnerDTO> getOwners(){
        if(null == owners){
            owners = new ArrayList<OwnerDTO>();
        }
        return owners;
    }

    public String getActionLabel() {
        return actionLabel;
    }

    public void setActionLabel(String actionLabel) {
        this.actionLabel = actionLabel;
    }

    public void setDogs(List<DogDTO> dogs) {
        this.dogs = dogs;
    }

    public void setOwners(List<OwnerDTO> owners) {
        this.owners = owners;
    }

    public DogDTO getDogDTO() {
        if (null == dogDTO){
            dogDTO = new DogDTO();

        }
        return dogDTO;
    }

    public void setDogDTO(DogDTO dogDTO) {
        this.dogDTO = dogDTO;
    }

    public OwnerDTO getOwnerDTO() {
        if (null == ownerDTO){
            ownerDTO = new OwnerDTO();
        }
        return ownerDTO;
    }

    public void setOwnerDTO(OwnerDTO ownerDTO) {
        this.ownerDTO = ownerDTO;
    }

}
