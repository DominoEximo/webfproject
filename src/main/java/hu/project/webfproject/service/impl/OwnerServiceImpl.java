package hu.project.webfproject.service.impl;

import hu.project.webfproject.dto.OwnerDTO;
import hu.project.webfproject.entities.Owner;
import hu.project.webfproject.repository.OwnerRepository;
import hu.project.webfproject.service.OwnerService;
import hu.project.webfproject.utils.OwnerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        ownerRepository.save(ownerMapper.OwnerDtoToOwner(owner));
    }

    @Override
    public void deleteOwner(OwnerDTO owner) {

        ownerRepository.delete(ownerMapper.OwnerDtoToOwner(owner));
    }
}
