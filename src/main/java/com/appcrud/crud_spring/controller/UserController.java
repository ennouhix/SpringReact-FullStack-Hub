package com.appcrud.crud_spring.controller;

import com.appcrud.crud_spring.entity.User;
import com.appcrud.crud_spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/user")

    public User postUser(@RequestBody User user){return userService.postUser(user);}
    @GetMapping("/users")
    public List<User> getAllUsers(){return userService.getAllUsers();}
    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id ){
        userService.deleteuser(id);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id ) {
        User user = userService.getUserById(id);
        if(user  == null ) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(user);
    }
    @PatchMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id , @RequestBody User user){
        boolean success = userService.updateUser(id, user);
        if(success) return ResponseEntity.ok().build();
        return  ResponseEntity.notFound().build();

    }
}
