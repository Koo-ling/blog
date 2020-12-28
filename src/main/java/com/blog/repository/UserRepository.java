package com.blog.repository;

import com.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;


public interface UserRepository  extends JpaRepository<User,Long>{
    User findById(Long id);
    User findByName(String name);

}
