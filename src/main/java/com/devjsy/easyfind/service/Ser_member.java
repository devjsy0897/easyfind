package com.devjsy.easyfind.service;

import com.devjsy.easyfind.entity.En_member;
import com.devjsy.easyfind.repository.Re_member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class Ser_member {

    @Autowired
    Re_member re_member;

    public List<En_member> selectAll(){
        List<En_member> list = re_member.findAll();
        return list;
    }

    public void signIn(HttpServletRequest request){
        String id = request.getParameter("id");
        String pw = request.getParameter("password");
        System.out.println("signIn에서 ID : "+id+" / pw:"+pw);

        // 로그인 로직 개발필요

    }

    public List<En_member> insertNewMember() {
        En_member en_member = new En_member();
        List<En_member> list = re_member.findAll(Sort.by(Sort.Direction.DESC, "idx"));
        int idx = 1;
        if(list!=null){
            idx = list.get(0).getIdx();
            idx++;
        }

        String pw = "password";
        for(int i=0;i<4;i++) {
            pw += ((int)((Math.random() * 10000) % 10))+"";
        }

        en_member.setId("test"+idx);
        en_member.setPassword(pw);
        en_member.setName("test"+idx);
        en_member.setLevel("1");

        re_member.save(en_member);

        list = re_member.findAll(Sort.by(Sort.Direction.DESC, "idx"));

        return list;
    }
}
