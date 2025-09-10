package com.amigoscode.registrationsystem.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List <User> findByNameIgnoreCase(String name);
    boolean existsByEmailAddressIgnoreCase(String email);
    List <User> findByEmailAddressIgnoreCase(String email);

}
