package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.UserModel;
import com.example.demo.services.UserService;

@RestController
@RequestMapping("/usuario")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping()
    public ArrayList<UserModel> findByAllUser() {
        return userService.findByAllUser();
    }

    @PostMapping()
    public UserModel registerNewUser(@RequestBody UserModel user) {
        return this.userService.registerNewUser(user);
    }

    @GetMapping(path = "/{id}")
    public Optional<UserModel> findByIdUser(@PathVariable("id") Long id) {
        return this.userService.findByIdUser(id);
    }

    @GetMapping("/query")
    public ArrayList<UserModel> findUserToPriority(@RequestParam("prioridad") Integer priority) {
        return this.userService.findUserToPriority(priority);
    }

    @PutMapping(path = "/{id}")
    public UserModel updateUser(@PathVariable("id") Long id, @RequestBody UserModel user) {
        return this.userService.updateUser(user, id);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean ok = this.userService.deleteUser(id);
        if (ok) {
            return "Se eliminó el usuario con id " + id;
        } else {
            return "No pudo eliminar el usuario con id" + id;
        }
    }
}
