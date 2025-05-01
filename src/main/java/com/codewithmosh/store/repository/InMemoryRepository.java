package com.codewithmosh.store.repository;

import com.codewithmosh.store.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemoryRepository implements UserRepository {
    private Map<String, User> userMap = new HashMap<>();
    @Override
    public void save(User user) {
        userMap.put(user.email(), user);
    }

    @Override
    public User findByEmail(String email) {
        return userMap.getOrDefault(email, null);
    }
}
