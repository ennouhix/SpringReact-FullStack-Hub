package com.appcrud.crud_spring.service;

import com.appcrud.crud_spring.entity.User;
import com.appcrud.crud_spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User postUser(User user){return userRepository.save(user); }
    public List<User> getAllUsers(){return userRepository.findAll();}

    public void deleteuser(long id) {userRepository.deleteById(id);}
    public User  getUserById(Long id){return  userRepository.findById(id).orElse(null);}

    public boolean updateUser(Long id , User user){
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            User existingUser = optionalUser.get();
            existingUser.setUsername(user.getUsername());
            existingUser.setEmail(user.getEmail());
            existingUser.setAddress(user.getAddress());
            existingUser.setPhoneNumber(user.getPhoneNumber());
            userRepository.save(existingUser);
            return true;

        }else {
            return false ;
        }
    }

}
