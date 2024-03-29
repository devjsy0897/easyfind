package com.devjsy.easyfind.service;

import com.devjsy.easyfind.entity.En_member;
import com.devjsy.easyfind.entity.En_save;
import com.devjsy.easyfind.repository.Re_member;
import com.devjsy.easyfind.repository.Re_save;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class Ser_data {

    @Autowired
    Re_save re_save;

    public List<En_save> findByUserId(List<En_member> userSession){

        List<En_save> list = re_save.findByUserId(userSession.get(0).getUserId());
        return list;
    }

    public List<En_save> findAllOrderByIn_dateDesc(){

        /*List<En_save> list = re_save.findAllOrderByIn_dateDesc("in_date");*/
        List<En_save> list = re_save.findAll();
        return list;
    }






}
