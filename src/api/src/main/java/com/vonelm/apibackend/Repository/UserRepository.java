package com.vonelm.apibackend.Repository;

import com.vonelm.apibackend.Model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Query(value = "SELECT u FROM User u WHERE u.email = ?1")
    Optional<User> findByEmail(String userEmail);

    @Query(value = "SELECT u FROM User u WHERE  u.email = ?1 AND u.password = ?2")
    Optional<User> findByEmailAndPassword(String userEmail, String userPassword);
}
