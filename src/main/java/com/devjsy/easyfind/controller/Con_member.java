package com.devjsy.easyfind.controller;

import com.devjsy.easyfind.entity.En_member;
import com.devjsy.easyfind.service.Ser_member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
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
    public String memberSignInView(){
        return "/member/member_signIn";
    }

    @PostMapping("/signIn")
    public String signIn(HttpServletRequest request){

        Boolean signInResult = ser_member.signIn(request);

        // model에 id 담아서 redirect로 data_list 이동해야함
        if(signInResult==true) {
            return "redirect:/data/list";
        }
        else{
            return "/member/member_signIn";
        }
    }


    @GetMapping("/signUp")
    public String memberSignUp(Model model){
        System.out.println("signup 입장");
        List<En_member> list = ser_member.insertNewMember();

        model.addAttribute("newID",list.get(0).getUserId());
        model.addAttribute("newPW",list.get(0).getUserPw());

        return "/member/member_signIn";
    }

}
