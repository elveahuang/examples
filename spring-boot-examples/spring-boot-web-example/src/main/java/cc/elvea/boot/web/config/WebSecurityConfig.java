package cc.elvea.boot.web.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@AllArgsConstructor
@EnableWebSecurity
@EnableMethodSecurity
@Configuration(proxyBeanMethods = false)
public class WebSecurityConfig implements WebMvcConfigurer {

    @Bean
    @Order(1)
    public SecurityFilterChain mobileSecurityChain(HttpSecurity http) throws Exception {
        return http.securityMatcher("/api/**")
                .cors(AbstractHttpConfigurer::disable)
                .sessionManagement(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request -> request.anyRequest().permitAll())
                .build();
    }

    @Bean
    public SecurityFilterChain webSecurityChain(HttpSecurity http) throws Exception {
        return http.sessionManagement(Customizer.withDefaults())
                .authorizeHttpRequests(request -> request.anyRequest().permitAll())
                .build();
    }

}
