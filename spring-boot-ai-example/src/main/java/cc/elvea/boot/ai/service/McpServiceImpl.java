package cc.elvea.boot.ai.service;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

@Service
public class McpServiceImpl implements McpService {

    @Tool(name = "say-hello", description = "Say Hello")
    public String sayHello(String name) {
        return "Hello " + name;
    }

}
