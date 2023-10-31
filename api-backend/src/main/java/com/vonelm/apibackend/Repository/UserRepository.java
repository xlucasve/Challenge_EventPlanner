package com.vonelm.apibackend.Repository;

import com.vonelm.apibackend.Model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
