package com.aecioprado.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aecioprado.api.model.User;
import com.aecioprado.api.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Page<User> listAllUsers(Pageable pageable) throws Exception {
        return userRepository.findAll(pageable);
    }

}
