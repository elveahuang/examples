package cc.elvea.boot.web.config;

import cc.elvea.boot.web.filter.ResourceFilter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@AllArgsConstructor
@Configuration(proxyBeanMethods = false)
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    public ResourceFilter resourceFilter() {
        return new ResourceFilter();
    }

}
