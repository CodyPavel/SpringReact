package com.example.SpringReact.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer",
        "handler"})
@Table(name="owners")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ownerId;

    @NonNull
    private String firstname;
    @NonNull
    private String lastname;

    @ManyToMany(cascade=CascadeType.PERSIST)
    @JoinTable(name="car_owner",
            joinColumns = { @JoinColumn(name="ownerid") },
            inverseJoinColumns = { @JoinColumn(name="id") })
    @JsonIgnore
    private Set<Car> cars = new HashSet<Car>();

}

