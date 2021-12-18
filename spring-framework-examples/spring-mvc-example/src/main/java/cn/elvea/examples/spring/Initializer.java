package cn.elvea.examples.spring;

import cn.elvea.examples.spring.config.Config;
import cn.elvea.examples.spring.config.WebMvcConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Initializer
 */
@Slf4j
@Configuration
public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        log.info("Initializer.getRootConfigClasses.");
        return new Class[]{Config.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        log.info("Initializer.getServletConfigClasses.");
        return new Class[]{WebMvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        log.info("Initializer.getServletMappings.");
        return new String[]{"/"};
    }

}
