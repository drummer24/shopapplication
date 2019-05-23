/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.shop.controllers;

import com.project.shop.models.order;
import com.project.shop.models.user;
import com.project.shop.repozitoris.orderrepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.project.shop.repozitoris.userrepozitory;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author admin
 */
@RestController
public class usercontroller {
    @Autowired
    userrepozitory userrepo;
    @Autowired
    orderrepository orderrepo;
    @CrossOrigin
    @GetMapping("/users")
    public List<user> allusers() {
        return userrepo.findAll();
    }  
    
    @CrossOrigin
    @PostMapping("/newuser")
    public String newuser(@RequestBody user newuser) {
        System.out.println(newuser);
        userrepo.save(newuser);
       
        return "user addet succesfully";
    
    }
    @CrossOrigin
    @PostMapping("/neworder")
    public String neworder(@RequestBody order neworder) {
        System.out.println(neworder);
        orderrepo.save(neworder);
       
        return "user addet succesfully";
    }
}
