package com.example.SpringReact.controller;

import com.example.SpringReact.entity.Car;
import com.example.SpringReact.repo.CarRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CarController {

    private final CarRepo carRepo;

    @GetMapping("/cars")
    public List<Car> getCars() {
        List<Car> cars = new ArrayList<>();
        carRepo.findAll().forEach(cars::add);
        return cars;
    }

}
