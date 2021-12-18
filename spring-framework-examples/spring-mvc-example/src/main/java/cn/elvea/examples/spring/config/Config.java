package cn.elvea.examples.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(
        basePackages = {"cn.elvea.examples.spring"},
        excludeFilters = {@ComponentScan.Filter(Controller.class)}
)

public class Config {
}
