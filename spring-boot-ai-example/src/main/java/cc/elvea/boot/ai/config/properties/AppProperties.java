package cc.elvea.boot.ai.config.properties;

import lombok.Builder;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@Data
@ConfigurationProperties(AppProperties.PREFIX)
public class AppProperties {

    public static final String PREFIX = "app";

    /**
     * 阿里云
     */
    @NestedConfigurationProperty
    private DashScopeConfig dashScope = DashScopeConfig.builder().build();

    @Data
    @Builder
    public static class DashScopeConfig {
        private String apiKey;
        private String model;
    }

}
