package cc.elvea.boot.crawler.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class DefaultController {

    @RequestMapping()
    public String index() {
        return "Hello World";
    }

}
