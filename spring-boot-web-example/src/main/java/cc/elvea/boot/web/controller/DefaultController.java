package cc.elvea.boot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DefaultController {

    @RequestMapping()
    public String index() {
        return "index";
    }

}
