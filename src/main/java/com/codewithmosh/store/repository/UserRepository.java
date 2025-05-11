package com.codewithmosh.store.repository;

import com.codewithmosh.store.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
