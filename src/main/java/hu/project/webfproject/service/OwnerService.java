package hu.project.webfproject.service;

import hu.project.webfproject.dto.OwnerDTO;
import hu.project.webfproject.entities.Owner;

import java.util.List;

public interface OwnerService {

    List<OwnerDTO> getAllOwners();

    void saveOwner(OwnerDTO owner);

    void deleteOwner(OwnerDTO owner);


}
