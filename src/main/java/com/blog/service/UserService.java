package com.blog.service;

import com.blog.model.User;

import java.util.List;


public interface UserService {
    void save(User user);
    void delete(Long id);
    void update(User user);
    List<User> findAll();
    User findById(Long id);

    User findByName(String name);
}
