package hu.project.webfproject.controller;

import hu.project.webfproject.dto.DogDTO;
import hu.project.webfproject.dto.OwnerDTO;
import hu.project.webfproject.entities.Dog;
import hu.project.webfproject.service.OwnerService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@ViewScoped
public class OwnerController {

    @Autowired
    OwnerService ownerService;

    List<OwnerDTO> owners;

    OwnerDTO currentOwner;

    private String actionLabel;

    @PostConstruct
    public void getAllOwners(){
        if (this.getOwners().isEmpty()){
            this.getOwners().clear();
        }
        this.getOwners().addAll(ownerService.getAllOwners());
        this.setActionLabel("Add");
        getCurrentOwner();
        this.currentOwner.setId(null);
    }

    public void saveOwner(){
        //TODO
    }

    public void deleteOwner(OwnerDTO ownerDTO){
        //TODO
    }

    public void updateOwner(OwnerDTO ownerDTO){
        setActionLabel("Update");
        currentOwner.setAge(ownerDTO.getAge());
        currentOwner.setName(ownerDTO.getName());
        currentOwner.setGender(ownerDTO.getGender());
        currentOwner.setId(ownerDTO.getId());
        currentOwner.setDogs(ownerDTO.getDogs());
    }

    public List<String> convertDogsToDogNames(List<Dog> dogs){
        return dogs.stream().map(dog -> dog.getName()).collect(Collectors.toList());
    }

    public List<OwnerDTO> getOwners() {
        if (null == owners){
            owners = new ArrayList<>();
        }
        return owners;
    }

    public void setOwners(List<OwnerDTO> owners) {
        this.owners = owners;
    }

    public OwnerDTO getCurrentOwner() {
        if (null == currentOwner){
            currentOwner = new OwnerDTO();
        }
        return currentOwner;
    }

    public void setCurrentOwner(OwnerDTO currentOwner) {
        this.currentOwner = currentOwner;
    }

    public String getActionLabel() {
        return actionLabel;
    }

    public void setActionLabel(String actionLabel) {
        this.actionLabel = actionLabel;
    }
}
