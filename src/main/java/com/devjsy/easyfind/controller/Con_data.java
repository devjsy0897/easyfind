package com.devjsy.easyfind.controller;

import com.devjsy.easyfind.entity.En_save;
import com.devjsy.easyfind.service.Ser_data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/data")
public class Con_data {

    @Autowired
    Ser_data ser_data;

    @GetMapping("/list")
    public String dataList(Model model) throws Exception{
        System.out.println("data/list");

        List<En_save> list = ser_data.selectAll();
        model.addAttribute("list", list);
        return "/data/data_list";
    }

    @GetMapping("/saveBarcode")
    public String saveBarcode(){
        return "/data/data_saveBarcode_quagga";
    }

    @PostMapping("/save")
    public String save(Model model){
        String barcodeInfo = (String)model.getAttribute("barcodeInfo");
        System.out.println("barcodeInfo:"+barcodeInfo);
        return "/data/data_save";
    }

}
