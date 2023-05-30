package com.example.swagger.service;

import com.example.swagger.entities.User;
import com.example.swagger.logging.Log;
import com.example.swagger.repos.UserRepo;
import com.example.swagger.request.UserUpdateRequest;
import com.example.swagger.response.LoginUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

//    public UserService(UserRepo userRepo) {
//        this.userRepo = userRepo;
//    }

    public List<User> getAllUsers() {
        Log.warn("All user get");
        return userRepo.findAll();
    }

    public User getUserById(Long id) {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()){
            Log.warn("Get user, id: " + id);
            return userRepo.findById(id).get();
        }else {
            Log.error("User not found for get by id, id: " + id);
            return null;
        }
    }

    public LoginUserResponse getUserByUserName(String userName){
        LoginUserResponse loginUserResponse = new LoginUserResponse();
        Optional<User> user = userRepo.findByUserName(userName);
        if(user.isPresent()){
            User foundUser = user.get();
            loginUserResponse.setUserName(foundUser.getUserName());
            loginUserResponse.setPassword(foundUser.getPassword());
            Log.warn("User info is get for login process");
            return loginUserResponse;
        }else {
            Log.error("User is not found for get");
            return null;
        }
    }

    public User createUser(User createUser) {
        Optional<User> user = userRepo.findByUserName(createUser.getUserName());
        if (user.isPresent()){
            Log.error("No User Created Clease Use a Different Username");
            return null;
        }else{
            Log.warn("New user is created");
            return userRepo.save(createUser);
        }
    }

    public User updateUser(Long userId, UserUpdateRequest newUser) { // user güncellemek için kullanıcaz
        Optional<User> user = userRepo.findById(userId);
        if(user.isPresent()){ // user var mı yok mu kontrolü burada yapılıyor.
            User foundUser = user.get();
            foundUser.setUserName(newUser.getUserName());
            foundUser.setEmail(newUser.getEmail());
            foundUser.setPassword(newUser.getPassword());
            foundUser.setCity(newUser.getCity());
            foundUser.setPhone(newUser.getPhone());
            foundUser.setAbout(newUser.getAbout());
            userRepo.save(foundUser);
            Log.warn("User is updated, id: " + userId);
            return foundUser;
        }else {
            Log.error("User not found for update");
            return null;
        }
    }

    public void deleteUserById(Long id){
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()){
            userRepo.deleteById(id);
            Log.warn("User is deleted, id: " + id);
        }else {
            Log.error("User not found for delete");
        }

    }

}
