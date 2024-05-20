package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.UserModel;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public ArrayList<UserModel> findByAllUser(){
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public UserModel registerNewUser(UserModel user){
        return userRepository.save(user);
    }

    public Optional<UserModel> findByIdUser(Long id){
        return userRepository.findById(id);
    }


    public ArrayList<UserModel> findUserToPriority(Integer priority) {
        return userRepository.findByPriority(priority);
    }

    public UserModel updateUser(UserModel user, Long id) {
        user.setId(id);
        return userRepository.save(user);
    }

    public boolean deleteUser(Long id) {
        try{
            userRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
