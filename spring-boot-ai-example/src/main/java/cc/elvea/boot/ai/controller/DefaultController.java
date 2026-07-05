package cc.elvea.boot.ai.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class DefaultController {

    private final ChatModel chatModel;

    @RequestMapping()
    public String index() {
        return "Hello World";
    }

}
