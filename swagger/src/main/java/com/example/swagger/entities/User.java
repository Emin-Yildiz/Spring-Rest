package com.example.swagger.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Data // Data anotasyonu bizim için setter getter metodlarını yazar ve aynı zamanda toString() gibi metodlarıda hazırlar.
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "username",unique = true)
    private String userName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "phone")
    private String phone;
    @Column(name = "city")
    private String city;
    @Column(name = "about")
    private String about;
    @Column(name = "gender")
    private boolean gender;

}
