package cc.elvea.boot.ai.controller;

import cc.elvea.boot.ai.embabel.EmbabelAgent.Greeting;
import com.embabel.agent.core.*;
import com.embabel.agent.domain.io.UserInput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

/**
 * 通过 HTTP 触发 Embabel Agent 的示例接口。
 *
 * <p>访问 {@code GET /embabel/hello?name=xxx} 即可运行 {@code helloWorldAgent} 并返回问候语。</p>
 */
@Slf4j
@RestController
@RequestMapping("/embabel")
@RequiredArgsConstructor
public class EmbabelController {

    private final AgentPlatform agentPlatform;

    @GetMapping("/hello")
    public String hello(@RequestParam(defaultValue = "World") String name) {
        Agent agent = agentPlatform.agents().stream()
            .filter(a -> "helloWorldAgent".equals(a.getName()))
            .findFirst()
            .orElseThrow(() -> new IllegalStateException("未找到 helloWorldAgent，请确认 EmbabelAgent 已被扫描注册"));

        UserInput input = new UserInput("我的名字是 " + name);
        AgentProcess process = agentPlatform.createAgentProcessFrom(agent, ProcessOptions.DEFAULT, input);
        CompletableFuture<AgentProcess> future = agentPlatform.start(process);
        process = future.join();

        if (process.getStatus() == AgentProcessStatusCode.COMPLETED) {
            Greeting greeting = process.resultOfType(Greeting.class);
            return greeting.message();
        }
        throw new RuntimeException("Agent 执行未成功完成，当前状态：" + process.getStatus());
    }
}
