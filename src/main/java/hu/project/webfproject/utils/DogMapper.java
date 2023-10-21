package hu.project.webfproject.utils;

import hu.project.webfproject.dto.DogDTO;
import hu.project.webfproject.entities.Dog;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DogMapper {

    DogMapper INSTANCE = Mappers.getMapper(DogMapper.class);

    @Mapping(source ="id" ,target ="dogDtoId" )
    @Mapping(source ="name" ,target ="dogName" )
    @Mapping(source ="breed" ,target ="dogBreed" )
    @Mapping(source ="gender" ,target ="dogGender" )
    @Mapping(source ="owner" ,target ="dogOwner" )
    DogDTO DogtoDogDto(Dog dog);

    @Mapping(source ="dogDtoId" ,target ="id" )
    @Mapping(source ="dogName" ,target ="name" )
    @Mapping(source ="dogBreed" ,target ="breed" )
    @Mapping(source ="dogGender" ,target ="gender" )
    @Mapping(source ="dogOwner" ,target ="owner" )
    Dog DogDtoToDog(DogDTO dogDto);

    @Mapping(source ="id" ,target ="dogDtoId" )
    @Mapping(source ="name" ,target ="dogName" )
    @Mapping(source ="breed" ,target ="dogBreed" )
    @Mapping(source ="gender" ,target ="dogGender" )
    @Mapping(source ="owner" ,target ="dogOwner" )
    List<DogDTO> DogListToDogDtoList(List<Dog> dogs);

    @Mapping(source ="dogDtoId" ,target ="id" )
    @Mapping(source ="dogName" ,target ="name" )
    @Mapping(source ="dogBreed" ,target ="breed" )
    @Mapping(source ="dogGender" ,target ="gender" )
    @Mapping(source ="dogOwner" ,target ="owner" )
    List<Dog> DogDtoListToDogList(List<DogDTO> dogDtos);
}
