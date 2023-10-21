package hu.project.webfproject.utils;

import hu.project.webfproject.dto.DogDTO;
import hu.project.webfproject.entities.Dog;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DogMapper {

    DogMapper INSTANCE = Mappers.getMapper(DogMapper.class);


    DogDTO DogtoDogDto(Dog dog);

    Dog DogDtoToDog(DogDTO dogDto);

    List<DogDTO> DogListToDogDtoList(List<Dog> dogs);

    List<Dog> DogDtoListToDogList(List<DogDTO> dogDtos);
}
