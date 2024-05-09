package com.example.gateway.filter;

import com.example.gateway.config.Carousel;
import com.example.gateway.utils.JwtUtil;
import jakarta.servlet.http.HttpServlet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.refresh.ConfigDataContextRefresher;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.MapRequestHeaderGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

    private final RouteValidator validator;
    private final RestTemplate template;
    private final JwtUtil jwtUtil;
    private final ConfigDataContextRefresher configDataContextRefresher;
    @Value("${spring.profiles.active}")
    private String activeProfile;
    private Carousel carousel;

    public AuthenticationFilter(RouteValidator validator, RestTemplate template, JwtUtil jwtUtil, Carousel carousel, ConfigDataContextRefresher configDataContextRefresher) {
        super(Config.class);
        this.validator = validator;
        this.template = template;
        this.jwtUtil = jwtUtil;
        this.carousel = carousel;


    }
}
