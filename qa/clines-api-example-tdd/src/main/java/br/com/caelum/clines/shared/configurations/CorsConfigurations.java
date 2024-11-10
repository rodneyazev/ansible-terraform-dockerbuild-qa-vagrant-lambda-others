package br.com.caelum.clines.shared.configurations;

import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@AllArgsConstructor
@EnableConfigurationProperties(CorsConfigurationProperties.class)
public class CorsConfigurations implements WebMvcConfigurer {

    private final CorsConfigurationProperties corsProperties;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(corsProperties.getOrigins())
                .allowedMethods(corsProperties.getMethods())
                .allowedHeaders(corsProperties.getHeaders())
                .allowCredentials(corsProperties.isSendCredentials());
    }
}
