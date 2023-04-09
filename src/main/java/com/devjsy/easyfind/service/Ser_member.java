package com.devjsy.easyfind.service;

import com.devjsy.easyfind.entity.En_member;
import com.devjsy.easyfind.repository.Re_member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    public Boolean signIn(HttpServletRequest request, Model model){
        boolean result = false;
        String id = request.getParameter("id");
        String pw = request.getParameter("password");


        List<En_member> user = re_member.findByUserId(id);

        for(En_member l : user){
            System.out.println("l:"+l.getUserId());
        }

        if(user.size() == 0){
            return false;
        }

        if(user.get(0).getUserPw().equals(pw)){
            result = true;
        }


        if(result == true){
            // 여기 로그인 세션 등록
            HttpSession session = request.getSession();
            session.setAttribute("userSession", user);

            session = request.getSession();
            List<En_member> userSession = (List<En_member>)session.getAttribute("userSession");

            for(En_member u : userSession){
                System.out.println("gd:"+u.getUserId());
            }
        }
        return result;

    }

    public List<En_member> insertNewMember() {
        System.out.println("insertNewMember 입장");
        En_member en_member = new En_member();
        List<En_member> list = re_member.findAll(Sort.by(Sort.Direction.DESC, "idx"));

        int idx = 1;
        if(list.size()!=0){
            idx = list.get(0).getIdx();
            idx++;
        }

        String pw = "password";
        for(int i=0;i<4;i++) {
            pw += ((int)((Math.random() * 10000) % 10))+"";
        }

        en_member.setUserId("test"+idx);
        en_member.setUserPw(pw);
        en_member.setName("test"+idx);
        en_member.setLevel("1");

        re_member.save(en_member);

        list = re_member.findAll(Sort.by(Sort.Direction.DESC, "idx"));

        return list;
    }
}
