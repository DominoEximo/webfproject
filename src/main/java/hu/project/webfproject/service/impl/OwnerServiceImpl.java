package hu.project.webfproject.service.impl;

import hu.project.webfproject.dto.OwnerDTO;
import hu.project.webfproject.entities.Owner;
import hu.project.webfproject.repository.OwnerRepository;
import hu.project.webfproject.service.OwnerService;
import hu.project.webfproject.utils.OwnerMapper;
import jakarta.faces.application.FacesMessage;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    OwnerRepository ownerRepository;

    @Autowired
    OwnerMapper ownerMapper;
    @Override
    public List<OwnerDTO> getAllOwners() {

        return ownerMapper.OwnerListToOwnerDtoList(ownerRepository.findAll());
    }

    @Override
    public void saveOwner(OwnerDTO owner) {
        if (null == owner.getId()){
            ownerRepository.save(ownerMapper.OwnerDtoToOwner(owner));
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Owner notice", "Succesfully added new Owner!");
            PrimeFaces.current().dialog().showMessageDynamic(message);
        }else{
            Optional<Owner> ownerOptional = ownerRepository.findById(owner.getId());
            Owner existingOwner = ownerOptional.get();
            existingOwner.setName(owner.getName());
            existingOwner.setAge(owner.getAge());
            existingOwner.setGender(owner.getGender());
            existingOwner.setDogs(owner.getDogs());
            ownerRepository.save(existingOwner);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Owner notice", "Updated existing owner!");
            PrimeFaces.current().dialog().showMessageDynamic(message);


        }

    }

    @Override
    public void deleteOwner(OwnerDTO owner) {

        ownerRepository.delete(ownerMapper.OwnerDtoToOwner(owner));
    }
}
