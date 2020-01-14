package cn.elvea.samples.webflux.config;

import cn.elvea.samples.webflux.handler.DefaultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@EnableWebFlux
public class WebReactiveConfig implements WebFluxConfigurer {
    private final DefaultHandler defaultHandler;

    @Autowired
    public WebReactiveConfig(DefaultHandler defaultHandler) {
        this.defaultHandler = defaultHandler;
    }

    @Bean
    public RouterFunction<?> routerFunction() {
        return route(GET("/").and(accept(MediaType.APPLICATION_JSON)), defaultHandler::home);
    }

}
