package com.amigoscode.registrationsystem.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public Optional<User> viewProfile (@PathVariable (value = "userId") Integer userId){
        return userService.viewProfile(userId);
    }

    @PostMapping("/register")
    public void registerUser (@RequestBody User user) {
        userService.registerUser(user);
        return;
    }

    @GetMapping()
    public List <User> allUsers (){
        return userService.viewAllUsers();
    }

    @DeleteMapping("/{userId}")
    public void deleteUser (@PathVariable(value = "userId")Integer userId){
        userService.deleteUser(userId);
    }

}
