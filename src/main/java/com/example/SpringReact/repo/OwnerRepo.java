package com.example.SpringReact.repo;

import com.example.SpringReact.entity.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface OwnerRepo extends CrudRepository<Owner, Long> {
    Optional<Owner> findByFirstname(String firstName);
}
