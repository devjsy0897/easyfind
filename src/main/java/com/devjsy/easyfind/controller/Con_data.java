package com.devjsy.easyfind.controller;

import com.devjsy.easyfind.entity.En_member;
import com.devjsy.easyfind.entity.En_save;
import com.devjsy.easyfind.service.Ser_data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/data")
public class Con_data {

    @Autowired
    Ser_data ser_data;

    @GetMapping("/list")
    public String dataList(HttpServletRequest request, Model model) throws Exception{

        HttpSession session = request.getSession();
        List<En_member> userSession =  (List)session.getAttribute("userSession");
        System.out.println("datalist 에서loginModel:"+userSession.get(0).getUserId());

        // 지금은 test 한다고 전체를 가져오는건데 나중에는 id만 get 해서 selectbyId 해서 해당 id에 관한 정보만 빼내야 한다.
        List<En_save> list = ser_data.selectAll();
        model.addAttribute("list", list);
        return "/data/data_list";
    }

    @GetMapping("/barcode_in")
    public String barcode_in(Model model){
        model.addAttribute("type","in");
        return "/data/data_barcode_quagga";
    }

    @GetMapping("/barcode_out")
    public String barcode_out(Model model){
        model.addAttribute("type", "out");
        return "/data/data_barcode_quagga";
    }

    @PostMapping("/location")
    public String save(HttpServletRequest request, Model model){
        String barcodeInfo = request.getParameter("barcodeInfo");
        System.out.println("barcodeInfo:"+barcodeInfo);
        model.addAttribute("barcodeInfo",barcodeInfo);
        return "/data/data_location";
    }

}
