package com.example.SpringReact.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name="cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NonNull
    private String brand;
    @NonNull
    private String model;
    @NonNull
    private String color;
    @NonNull
    private String registerNumber;

    @NonNull
    private int yearOfProd;
    @NonNull
    private int price;

    @ManyToMany(mappedBy = "cars")
    private Set<Owner> owners = new HashSet<Owner>();
}
