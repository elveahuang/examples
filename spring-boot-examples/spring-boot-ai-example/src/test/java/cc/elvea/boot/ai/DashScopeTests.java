package cc.elvea.boot.ai;

import cc.elvea.boot.ai.config.properties.AppProperties;
import com.alibaba.dashscope.aigc.generation.Generation;
import com.alibaba.dashscope.aigc.generation.GenerationParam;
import com.alibaba.dashscope.aigc.generation.GenerationResult;
import com.alibaba.dashscope.common.Message;
import com.alibaba.dashscope.common.Role;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = AIApplication.class)
@Rollback(false)
public class DashScopeTests {

    @Autowired
    AppProperties properties;

    @Test
    public void baseTest() throws Exception {
        Generation gen = new Generation();
        Message userMsg = Message.builder()
                .role(Role.USER.getValue())
                .content("你是谁？")
                .build();
        GenerationParam param = GenerationParam.builder()
                .apiKey(this.properties.getDashScope().getApiKey())
                .model(this.properties.getDashScope().getModel())
                .messages(Collections.singletonList(userMsg))
                .resultFormat(GenerationParam.ResultFormat.MESSAGE)
                .build();
        GenerationResult result = gen.call(param);
        System.out.println("思考过程：");
        System.out.println(result.getOutput().getChoices().getFirst().getMessage().getReasoningContent());
        System.out.println("回复内容：");
        System.out.println(result.getOutput().getChoices().getFirst().getMessage().getContent());
    }

}
