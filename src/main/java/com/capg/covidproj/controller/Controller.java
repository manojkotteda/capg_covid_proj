package com.capg.covidproj.controller;

import com.capg.covidproj.consumers.NewsConsumer;
import com.capg.covidproj.modal.Articles;
import com.capg.covidproj.modal.User;
import com.capg.covidproj.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
public class Controller {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private NewsConsumer newsConsumer;

    @RequestMapping(path = "/",method = RequestMethod.GET)
    public User testMethod(){
        return userRepo.findAll().get(0);
    }

    @RequestMapping(path = "/getNews",method = RequestMethod.GET)
    public ArrayList<Articles> news(){
        return newsConsumer.retriveArticles();
    }
}
