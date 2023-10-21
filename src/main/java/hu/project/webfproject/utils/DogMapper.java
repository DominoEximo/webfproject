package hu.project.webfproject.utils;

import hu.project.webfproject.dto.DogDTO;
import hu.project.webfproject.entities.Dog;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface DogMapper {

    DogDTO DogtoDogDto(Dog dog);

    Dog DogDtoToDog(DogDTO dogDto);

    List<DogDTO> DogListToDogDtoList(List<Dog> dogs);

    List<Dog> DogDtoListToDogList(List<DogDTO> dogDtos);
}
