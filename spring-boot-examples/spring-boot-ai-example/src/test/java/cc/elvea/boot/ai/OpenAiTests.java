package cc.elvea.boot.ai;

import cc.elvea.boot.ai.config.properties.AppProperties;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = AIApplication.class)
@Rollback(false)
public class OpenAiTests {

    @Autowired
    private AppProperties properties;

    @Autowired
    private OpenAiChatModel chatModel;

    @Test
    public void baseTest() {
        ChatResponse response = this.chatModel.call(
                new Prompt(
                        "Generate the names of 5 famous pirates.",
                        OpenAiChatOptions.builder().build()
                ));
        System.out.println(response);
    }

}
