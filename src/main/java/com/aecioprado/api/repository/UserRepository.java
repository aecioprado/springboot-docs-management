package com.aecioprado.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aecioprado.api.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
