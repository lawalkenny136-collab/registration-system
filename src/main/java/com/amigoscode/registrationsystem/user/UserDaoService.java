package com.amigoscode.registrationsystem.user;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public class UserDaoService implements UserDao{

    private final UserRepository userRepository;

    public UserDaoService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> selectAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> selectUserById(Integer userId) {
        return userRepository.findById(userId);
    }

    @Override
    public boolean existsByEmailAddress(String email) {
        return userRepository.existsByEmailAddressIgnoreCase(email);
    }

    @Override
    public List<User> findByEmail(String email) {
        return userRepository.findByEmailAddressIgnoreCase(email);
    }

    @Override
    public List<User> findByname(String name) {
        return userRepository.findByNameIgnoreCase(name);
    }

    public List<User> selectUserByName (String userName){
        return userRepository.findByNameIgnoreCase(userName);
    }

    public boolean existByUserId (Integer userId){
        return userRepository.existsById(userId);
    }

    public void createUser (User user) {
        userRepository.save(user);
    }
    public void deleteUser (Integer userId) {
        userRepository.deleteById(userId);
    }


}
