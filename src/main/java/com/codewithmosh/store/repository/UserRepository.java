package com.codewithmosh.store.repository;

import com.codewithmosh.store.model.User;

public interface UserRepository {

    void save(final User user);
    User findByEmail(final String email);
}
