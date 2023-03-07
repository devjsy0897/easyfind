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
@RequestMapping("/member")
public class Con_member {

    @Autowired
    Ser_member ser_member;

    @GetMapping("/list")
    public String doMemberList(Model model) throws Exception{
        List<En_member> list = ser_member.selectAll();
        model.addAttribute("list",list);
        return "/member/member_list";
    }

    @GetMapping("/signIn")
    public String memberSignIn(){
        return "/member/member_signIn";
    }

    @GetMapping("/signUp")
    public String memberSignUp(){
        System.out.println("sign up입니다.");
        ser_member.insertNewMember();
        return "/member/member_signIn";
    }

}
