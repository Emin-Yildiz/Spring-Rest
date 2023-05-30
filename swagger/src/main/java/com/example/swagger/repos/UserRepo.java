package com.example.swagger.repos;

import com.example.swagger.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {

    @Query(value = "select * from omerdb.users where username = :userName", nativeQuery = true)
    Optional<User> findByUserName(@Param("userName")String userName);

}
