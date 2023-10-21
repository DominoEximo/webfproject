package hu.project.webfproject.service;

import hu.project.webfproject.entities.Owner;

import java.util.List;

public interface OwnerService {

    List<Owner> getAllOwners();

    void saveOwner();

    void deleteOwner();


}
