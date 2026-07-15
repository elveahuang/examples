package cc.elvea.boot.ai;

import cc.elvea.boot.ai.config.properties.AppProperties;
import io.agentscope.core.ReActAgent;
import io.agentscope.core.message.Msg;
import io.agentscope.extensions.model.openai.OpenAIChatModel;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = AIApplication.class)
@Rollback(false)
public class AgentScopeTests {

    @Autowired
    private AppProperties properties;

    @Test
    public void baseTest() {
        OpenAIChatModel model = OpenAIChatModel.builder()
            .apiKey(this.properties.getDeepseek().getApiKey())
            .modelName("deepseek-v4-flash")
            .baseUrl("https://api.deepseek.com")
            .build();

        ReActAgent jarvis = ReActAgent.builder()
            .name("Jarvis")
            .sysPrompt("You are an assistant named Jarvis.")
            .model(model)
            .build();

        // Send message
        Msg msg = Msg.builder()
            .textContent("你好")
            .build();

        Msg response = jarvis.call(msg).block();
        System.out.println(response.getTextContent());
    }

}
