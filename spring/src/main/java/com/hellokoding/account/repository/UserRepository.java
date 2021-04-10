package com.hellokoding.account.repository;

import com.hellokoding.account.model.User;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.password = :password WHERE u.username = :username")
    int updateUser(@Param("username") String username, @Param("password") String password);
}
