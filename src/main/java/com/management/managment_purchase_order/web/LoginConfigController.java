package com.management.managment_purchase_order.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginConfigController {
    @RequestMapping("/login")
    public String login(){
      return "login";
    }
}
