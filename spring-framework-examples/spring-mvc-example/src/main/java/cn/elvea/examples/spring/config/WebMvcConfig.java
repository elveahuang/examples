package cn.elvea.examples.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(
        basePackages = {"cn.elvea.examples.spring"},
        includeFilters = {@ComponentScan.Filter(Controller.class)}
)
public class WebMvcConfig implements WebMvcConfigurer {
}
