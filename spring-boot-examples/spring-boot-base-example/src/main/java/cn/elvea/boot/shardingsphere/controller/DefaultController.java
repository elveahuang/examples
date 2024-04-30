package cn.elvea.boot.shardingsphere.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DefaultController {

    @RequestMapping()
    public String index() {
        return "Hello World";
    }

}
