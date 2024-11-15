package com.aecioprado.api;

import com.aecioprado.api.model.User;
import com.aecioprado.api.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class DocumentsRestApiApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testUserPaginationAndSorting() {
		Pageable pageable = PageRequest.of(0, 5, Sort.by("firstName").ascending());
		Page<User> users = userRepository.findAll(pageable);
		assertEquals(5, users.getSize());
		assertTrue(users.getContent().get(0).getFirstName().compareTo(users.getContent().get(1).getFirstName()) <= 0);
	}

}
