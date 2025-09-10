package com.amigoscode.registrationsystem.user;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    List<User> selectAllUsers();
    Optional<User> selectUserById(Integer userId);
    boolean existsByEmailAddress(String email);
    List <User> findByEmail (String email);
    List <User> findByname (String name);
    boolean existByUserId (Integer userId);
}
