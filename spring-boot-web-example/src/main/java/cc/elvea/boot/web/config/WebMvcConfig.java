package cc.elvea.boot.web.config;

import cc.elvea.boot.web.commons.Constants;
import cc.elvea.boot.web.filter.ResourceFilter;
import com.google.common.collect.Maps;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

import java.util.Map;

@RequiredArgsConstructor
@Configuration(proxyBeanMethods = false)
public class WebMvcConfig implements WebMvcConfigurer {

    private final ThymeleafViewResolver thymeleafViewResolver;

    @Override
    public void configureViewResolvers(@Nullable ViewResolverRegistry registry) {
        Map<String, String> vars = Maps.newHashMap();
        vars.put("applicationVersion", Constants.VERSION);
        vars.put("applicationTitle", "Application");

        if (this.thymeleafViewResolver != null) {
            this.thymeleafViewResolver.setStaticVariables(vars);
        }
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
    }

    @Bean
    public ResourceFilter resourceFilter() {
        return new ResourceFilter();
    }

}
