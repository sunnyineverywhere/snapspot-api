package snap.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
@RequiredArgsConstructor
public class CorsConfig {

    @Value("${cors.allowed-origins}")
    private String allowedOrigins;

    @Value("${cors.allowed-methods}")
    private String allowedMethods;

    @Value("${cors.allowed-headers}")
    private String allowedHeaders;

    @Value("${cors.allow-credentials}")
    private Boolean allowCredentials;

    @Value("${cors.max-age}")
    private Long maxAge;

    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        config.setAllowCredentials(allowCredentials);

        // Comma-separated origins를 리스트로 변환
        Arrays.stream(allowedOrigins.split(","))
                .map(String::trim)
                .forEach(config::addAllowedOrigin);

        // Comma-separated methods를 리스트로 변환
        Arrays.stream(allowedMethods.split(","))
                .map(String::trim)
                .forEach(config::addAllowedMethod);

        // Headers 설정
        config.addAllowedHeader(allowedHeaders);

        config.setMaxAge(maxAge);

        // Exposed headers
        config.addExposedHeader("Authorization");
        config.addExposedHeader("refresh-token");
        config.addExposedHeader("Location");

        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}