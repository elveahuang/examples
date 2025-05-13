package cc.elvea.boot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @RequestMapping({"/web/", "/web/index"})
    public String index() {
        return "html/index.html";
    }

    @RequestMapping({"/jsp/", "/jsp/index"})
    public String indexJsp() {
        return "index";
    }

}
