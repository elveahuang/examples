package cc.elvea.boot.ai;

import com.embabel.agent.core.Agent;
import com.embabel.agent.core.AgentPlatform;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 验证 Embabel Agent 已被框架扫描并注册到 AgentPlatform。
 */
@SpringBootTest(classes = AIApplication.class)
public class EmbabelAgentTests {

    @Autowired
    private AgentPlatform agentPlatform;

    @Test
    public void agentRegisteredTest() {
        Assertions.assertNotNull(agentPlatform, "AgentPlatform 应当已自动配置");

        Agent agent = agentPlatform.agents().stream()
            .filter(a -> "helloWorldAgent".equals(a.getName()))
            .findFirst()
            .orElse(null);

        Assertions.assertNotNull(agent, "helloWorldAgent 应当已被注册到 AgentPlatform");
    }
}
