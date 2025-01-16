package com.proj.crud.repository;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import com.proj.crud.model.User;


@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

    public User findById(int id);

    List<User> findByStatus(User.Status status);

    Page<User> findAll(Pageable pageable);

}