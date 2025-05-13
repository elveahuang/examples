package cc.elvea.boot.web.config;

import cc.elvea.boot.web.filter.CustomSiteMeshFilter;
import cc.elvea.boot.web.filter.ResourceFilter;
import lombok.AllArgsConstructor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
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

    @Bean(name = "sitemeshFilter")
    public FilterRegistrationBean<CustomSiteMeshFilter> sitemeshFilter() {
        FilterRegistrationBean<CustomSiteMeshFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new CustomSiteMeshFilter());
        bean.addUrlPatterns("/jsp/*");
        bean.addInitParameter("configFile", "/WEB-INF/config/sitemesh.xml");
        return bean;
    }

}
