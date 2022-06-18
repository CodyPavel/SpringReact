package com.example.SpringReact.repo;

import com.example.SpringReact.entity.Car;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CarRepo extends PagingAndSortingRepository<Car, Long> {
}
