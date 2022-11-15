package cn.elvea.repo.spring.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DefaultController {

    @ResponseBody
    @RequestMapping({"/"})
    public String index() {
        return "Hello Spring MVC";
    }

}
