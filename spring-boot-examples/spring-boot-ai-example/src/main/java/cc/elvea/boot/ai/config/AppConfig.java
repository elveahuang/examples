package cc.elvea.boot.ai.config;

import cc.elvea.boot.ai.config.properties.AppProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties({AppProperties.class})
public class AppConfig {
}
