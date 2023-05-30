package com.example.swagger.request;

import lombok.Data;

@Data
public class UserUpdateRequest {

    String userName;
    String password;
    String email;
    String phone;
    String city;
    String about;
}
