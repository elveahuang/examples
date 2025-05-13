package cc.elvea.boot.web.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.session.FindByIndexNameSessionRepository;
import org.springframework.session.Session;
import org.springframework.session.security.SpringSessionBackedSessionRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@AllArgsConstructor
@EnableWebSecurity
@EnableMethodSecurity
@Configuration(proxyBeanMethods = true)
public class WebSecurityConfig implements WebMvcConfigurer {

    private FindByIndexNameSessionRepository<? extends Session> sessionRepository;

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
        return http
                .headers(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session
                        .maximumSessions(2)
                        .sessionRegistry(sessionRegistry())
                )
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/jsp/login").permitAll()
                        .anyRequest().permitAll()
                )
                .build();
    }

    @Bean
    public SpringSessionBackedSessionRegistry<? extends Session> sessionRegistry() {
        return new SpringSessionBackedSessionRegistry<>(this.sessionRepository);
    }

}
