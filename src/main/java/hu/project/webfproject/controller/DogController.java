package hu.project.webfproject.controller;

import hu.project.webfproject.dto.DogDTO;
import hu.project.webfproject.service.DogService;
import hu.project.webfproject.utils.DogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class DogController {

    @Autowired
    DogService dogService;

    @Autowired
    DogMapper dogMapper;

    List<DogDTO> dogs;



}
