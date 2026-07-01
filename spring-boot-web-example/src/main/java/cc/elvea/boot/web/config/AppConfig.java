package cc.elvea.boot.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisIndexedHttpSession;

@Configuration(proxyBeanMethods = false)
@EnableRedisHttpSession
@EnableRedisIndexedHttpSession(maxInactiveIntervalInSeconds = 3600)
public class AppConfig {
}
