package hu.project.webfproject.utils;


import hu.project.webfproject.dto.OwnerDTO;
import hu.project.webfproject.entities.Owner;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OwnerMapper {

    OwnerMapper INSTANCE = Mappers.getMapper(OwnerMapper.class);
    OwnerDTO OwnerToOwnerDto(Owner owner);

    Owner OwnerDtoToOwner(OwnerDTO ownerDTO);

    List<OwnerDTO> OwnerListToOwnerDtoList(List<Owner> owners);

    List<Owner> OwnerDtoListToOwnerList(List<OwnerDTO> ownerDtos);
}
