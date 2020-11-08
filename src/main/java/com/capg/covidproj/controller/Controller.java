package com.capg.covidproj.controller;

import com.capg.covidproj.modal.User;
import com.capg.covidproj.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private UserRepo userRepo;

    @RequestMapping(path = "/",method = RequestMethod.GET)
    public User testMethod(){

        return userRepo.findAll().get(0);

    }
}
