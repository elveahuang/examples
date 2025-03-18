package cc.elvea.boot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @RequestMapping("/web/")
    public String index() {
        return "html/index.html";
    }

    @RequestMapping("/jsp/")
    public String indexJsp() {
        return "index";
    }

}
