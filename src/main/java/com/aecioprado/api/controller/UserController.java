package com.aecioprado.api.controller;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aecioprado.api.model.User;
import com.aecioprado.api.repository.UserRepository;
import com.aecioprado.api.service.UserService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@RestController
public class UserController implements Serializable {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }

    @GetMapping("/users")
    public Page<User> listUsers(
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "10") int size,
            @RequestParam(value = "sort", defaultValue = "id") String sortBy,
            @RequestParam(value = "direction", defaultValue = "asc") String direction) {

        Sort sort = direction.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        PageRequest pageable = PageRequest.of(page, size, sort);

        try {
            return userService.listAllUsers(pageable);
        } catch (Exception e) {
            log.info(e.getMessage());
            return null;
        }
    }
}
