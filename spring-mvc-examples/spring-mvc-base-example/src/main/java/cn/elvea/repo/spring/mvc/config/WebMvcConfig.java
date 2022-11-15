package cn.elvea.repo.spring.mvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(
        basePackages = {"cn.elvea.repo.spring.mvc"},
        includeFilters = {@ComponentScan.Filter(Controller.class)}
)
public class WebMvcConfig {
}
