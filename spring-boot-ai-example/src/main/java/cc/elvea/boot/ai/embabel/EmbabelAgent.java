package cc.elvea.boot.ai.embabel;

import com.embabel.agent.api.annotation.AchievesGoal;
import com.embabel.agent.api.annotation.Action;
import com.embabel.agent.api.annotation.Agent;
import com.embabel.agent.api.common.Ai;
import com.embabel.agent.domain.io.UserInput;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

/**
 * 基于 Embabel Agent Framework 的 Hello World 示例。
 *
 * <p>该 Agent 接收一个 {@link UserInput}，先通过 LLM 从中提取用户姓名（{@link Person}），
 * 再生成一句友好的问候语（{@link Greeting}）作为目标结果返回。</p>
 *
 * <p>Embabel 会根据动作方法的「入参 / 返回值」自动推导前置条件与后置条件，
 * 并动态规划执行流程（本例为：extractPerson -> makeGreeting）。</p>
 */
@Agent(
    name = "helloWorldAgent",
    description = "向用户问好的智能助手"
)
public class EmbabelAgent {

    /**
     * 第一步：调用 LLM，从用户输入中提取用户姓名。
     */
    @Action
    public Person extractPerson(UserInput userInput, Ai ai) {
        return ai.withDefaultLlm().createObject(
            "请从下面的用户输入中提取用户姓名，如果没有明确姓名则使用「朋友」：\n"
                + userInput.getContent(),
            Person.class
        );
    }

    /**
     * 第二步（目标动作）：调用 LLM，基于用户姓名生成问候语，并标记目标达成。
     */
    @AchievesGoal(description = "生成并向用户返回问候语")
    @Action
    public Greeting makeGreeting(Person person, Ai ai) {
        return ai.withDefaultLlm().createObject(
            "请为 " + person.name() + " 生成一句简洁、温暖的中文问候语。",
            Greeting.class
        );
    }

    /**
     * 用户信息领域对象，在动作之间流转。
     */
    @JsonClassDescription("用户信息")
    public record Person(
        @JsonPropertyDescription("用户姓名") String name
    ) {
    }

    /**
     * 问候语领域对象，作为 Agent 的最终输出。
     */
    @JsonClassDescription("问候语")
    public record Greeting(
        @JsonPropertyDescription("问候语内容") String message
    ) {
    }
}
