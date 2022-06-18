package com.example.SpringReact;

import com.example.SpringReact.entity.Car;
import com.example.SpringReact.entity.Owner;
import com.example.SpringReact.entity.User;
import com.example.SpringReact.repo.CarRepo;
import com.example.SpringReact.repo.OwnerRepo;
import com.example.SpringReact.repo.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.HashSet;

@Slf4j
@SpringBootApplication
public class SpringReactApplication implements CommandLineRunner {

    private CarRepo carRepo;
    private OwnerRepo ownerRepo;
    private UserRepo userRepo;

    @Autowired
    private void setUserRepo(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Autowired
    private void setOwnerRepo(OwnerRepo ownerRepo) {
        this.ownerRepo = ownerRepo;
    }

    @Autowired
    private void setCarRepo(CarRepo carRepo) {
        this.carRepo = carRepo;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringReactApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner("John", "Johnson");
        Owner owner2 = new Owner("Mary", "Robinson");
        Owner owner3 = new Owner("Mary", "Robinson");
        ownerRepo.saveAll(Arrays.asList(owner1, owner2, owner3));

        Car car1 = new Car("Ford", "Mustang", "Red", "ADF - 1121", 2021, 59000);
        car1 = carRepo.save(car1);
        car1.getOwners().add(owner1);

        Car finalCar = car1;
        owner1.setCars(new HashSet<>() {
            @Override
            public boolean add(Car car) {
                return super.add(finalCar);
            }
        });//car1);
        carRepo.save(car1);
        ownerRepo.save(owner1);

        Car car2 = new Car("Nissan", "Leaf", "White", "SSJ - 3002", 2019, 29000);
        car2.getOwners().add(owner2);
        carRepo.save(car2);

        Car car3 = new Car("Toyota", "Prius", "Silver", "KKO - 0212", 2020, 39000);
        car3.getOwners().add(owner2);
        carRepo.save(car3);

        HashSet<Car> cars = new HashSet<>();
        cars.add(car2);
        cars.add(car3);
        owner2.setCars(cars);

        ownerRepo.save(owner2);

        for (Car car : carRepo.findAll()) {
            log.info(car.getBrand() + " " + car.getModel());
        }

        userRepo.save(new User("user", "$2a$10$NVM0n8ElaRgg7zWO1CxUdei7vWoPg91Lz2aYavh9.f9q0e4bRadue", " USER"));
        userRepo.save(new User("admin", "$2a$10$8cjz47bjbR4Mn8GMg9IZx.vyjhLXR/SKKMSZ9.mP9vpMu0ssKi8GW", " ADMIN"));
    }
}
