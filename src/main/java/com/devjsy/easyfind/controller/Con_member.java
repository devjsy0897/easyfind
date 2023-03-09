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

    @GetMapping("/signInView")
    public String memberSignInView(){
        return "/member/member_signIn";
    }

    @PostMapping("/signIn")
    public String signIn(Model model){

        ser_member.signIn(model);

        return "redirect:/member/list";

    }


    @GetMapping("/signUp")
    public String memberSignUp(Model model){
        System.out.println("sign up입니다.");
        List<En_member> list = ser_member.insertNewMember();

        model.addAttribute("newID",list.get(0).getId());
        model.addAttribute("newPW",list.get(0).getPassword());

        return "/member/member_signIn";
    }

}
