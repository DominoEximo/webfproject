package hu.project.webfproject.utils;


import hu.project.webfproject.dto.OwnerDTO;
import hu.project.webfproject.entities.Owner;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface OwnerMapper {

    OwnerDTO OwnerToOwnerDto(Owner owner);

    Owner OwnerDtoToOwner(OwnerDTO ownerDTO);

    List<OwnerDTO> OwnerListToOwnerDtoList(List<Owner> owners);

    List<Owner> OwnerDtoListToOwnerList(List<OwnerDTO> ownerDtos);
}
