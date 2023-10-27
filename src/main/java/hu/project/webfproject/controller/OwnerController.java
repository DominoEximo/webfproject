package hu.project.webfproject.controller;

import hu.project.webfproject.dto.OwnerDTO;
import hu.project.webfproject.entities.Dog;
import hu.project.webfproject.service.OwnerService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.RequestScope;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestScope
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    private List<OwnerDTO> owners;

    private OwnerDTO currentOwner;

    private String actionLabel;

    @PostConstruct
    public void getAllOwners(){
        if (!this.getOwners().isEmpty()){
            this.getOwners().clear();
        }
        this.getOwners().addAll(ownerService.getAllOwners());
        this.setActionLabel("Add");
        getCurrentOwner();
        this.currentOwner.setId(null);
    }

    public void saveOwner(){
        ownerService.saveOwner(this.currentOwner);
        getAllOwners();
    }

    public void deleteOwner(OwnerDTO ownerDTO){
        ownerService.deleteOwner(ownerDTO);
        owners.clear();
        getAllOwners();
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
        if(dogs != null){
            return dogs.stream().map(dog -> dog.getName()).collect(Collectors.toList());
        }
        return new ArrayList<String>();

    }

    public List<Long> convertOwnersToNames(List<OwnerDTO> owners){
        if(owners != null){
            return owners.stream().map(owner -> owner.getId()).collect(Collectors.toList());
        }
        return new ArrayList<Long>();
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
