package com.aecioprado.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aecioprado.api.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
