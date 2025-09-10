package com.amigoscode.registrationsystem.user;

import com.amigoscode.registrationsystem.exception.DuplicateResourceException;
import com.amigoscode.registrationsystem.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserDaoService userDaoService;
    private Integer userId;

    public UserService(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }
    public List <User> viewAllUsers (){
        return userDaoService.selectAllUsers();
    }

    public Optional<User> viewProfile(Integer userId){
        return userDaoService.selectUserById(userId);
    }
    public boolean doesUserIdExist (Integer userId){
        return userDaoService.existByUserId(userId);
    }

    public boolean doesEmailExist (String email){
        return userDaoService.existsByEmailAddress(email);
    }

    public void registerUser (User user){
        if (doesEmailExist(user.getEmailAddress()) == true) {
            throw new DuplicateResourceException ("email already taken");

        }
        else {
            userDaoService.createUser(user);
        }
    }
   /* public void updateProfile (String email){
        if (userDaoService.existsByEmailAddress(email)){
            userDaoService.findByEmail(email);}
        else {
            throw new DuplicateResourceException("email doesnt exist");
        }

    }*/

    public void deleteUser (Integer userId){
        if (userDaoService.existByUserId(userId) == true){
            userDaoService.deleteUser(userId);}
        else {throw new ResourceNotFoundException("user with id  [%s] not found".formatted(userId));}

    }
}
