package com.bcx.web.controller;

import com.bcx.base.ApiResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("name","youzhi");
        model.addAttribute("name2","youzhi2");
        model.addAttribute("name3","youzhi3");
        return "index";
    }

    @GetMapping("/get")
    @ResponseBody
    public ApiResponse get(){
        return ApiResponse.ofMessage(200,"妥妥的");
    }
}
