package com.devjsy.easyfind.controller;

import com.devjsy.easyfind.entity.En_member;
import com.devjsy.easyfind.service.Ser_member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class Con_common {

//    @Autowired
//    Ser_member ser_member;

    @GetMapping("/")
    public String mainPage(){

        return "/common/main";
    }



}
