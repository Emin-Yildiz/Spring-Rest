package com.example.swagger.controller;

import com.example.swagger.entities.User;
import com.example.swagger.request.UserUpdateRequest;
import com.example.swagger.response.LoginUserResponse;
import com.example.swagger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/user")
@CrossOrigin()
public class UserController {

    @Autowired
    private UserService userService;

//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    /*
    RequestBody bir modeli temsil eder bu projedeki user gibi
    Eğer sadece bir parametre alacak isem RequestParam kullanılır.
     */
    @GetMapping()
    public LoginUserResponse getUser(@RequestParam String userName){
        return userService.getUserByUserName(userName);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id ,@RequestBody UserUpdateRequest newUser) {
        return userService.updateUser(id,newUser);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
    }

}
