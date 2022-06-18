package com.example.SpringReact.repo;

import com.example.SpringReact.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(exported = false)
public interface UserRepo extends CrudRepository<User, Long> {

    Optional<User> findByUsername(String username);

}
