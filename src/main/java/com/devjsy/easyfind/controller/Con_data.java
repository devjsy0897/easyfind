package com.devjsy.easyfind.controller;

import com.devjsy.easyfind.entity.En_save;
import com.devjsy.easyfind.service.Ser_data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/data")
public class Con_data {

    @Autowired
    Ser_data ser_data;

    @GetMapping("/list")
    public String dataList(Model model) throws Exception{

        // 지금은 test 한다고 전체를 가져오는건데 나중에는 id만 get 해서 selectbyId 해서 해당 id에 관한 정보만 빼내야 한다.
        List<En_save> list = ser_data.selectAll();
        model.addAttribute("list", list);
        return "/data/data_list";
    }

    @GetMapping("/barcode")
    public String saveBarcode(){
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
