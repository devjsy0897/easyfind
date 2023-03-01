package com.devjsy.easyfind.service;

import com.devjsy.easyfind.entity.En_member;
import com.devjsy.easyfind.repository.Re_member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Ser_member {

    @Autowired
    Re_member re_member;
    public List<En_member> selectAll(){
        List<En_member> list = re_member.findAll();
        System.out.println("------------ service 에서 id list ------------");
        for(En_member l : list){
            System.out.println(l);
        }
        return list;
    }
}
