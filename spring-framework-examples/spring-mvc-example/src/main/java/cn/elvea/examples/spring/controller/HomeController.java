package cn.elvea.examples.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HomeController {

    @ResponseBody
    @RequestMapping
    public String hello() {
        return "Hello World!";
    }

}
