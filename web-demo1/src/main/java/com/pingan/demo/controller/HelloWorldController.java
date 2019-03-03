package com.pingan.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author TANGJIAN
 * @since 2019-03-03 14:26
 */
@Controller
public class HelloWorldController {

    @RequestMapping("")
    public String index(@RequestParam(required = false,defaultValue = "0") int value, Model model) {
        return "index";
    }

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "hello-world"; // View 逻辑名称
    }

    @ModelAttribute("message")
    public String message() {
        return "HelloWorld";
    }
}
