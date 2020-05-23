package cn.elvea.samples.spring.boot.oauth.client.config;

import cn.elvea.samples.spring.boot.hander.UserHander;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.web.servlet.function.RouterFunctions.route;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {
    @Bean
    RouterFunction<ServerResponse> routes(UserHander userHander) {
        String root = "";
        return route()
                .GET(root + "/", userHander::handleIndex)
                .filter((serverRequest, handlerFunction) -> {
                    try {
                        System.out.println("entering HandlerFilterFunction");
                        return handlerFunction.handle(serverRequest);
                    } finally {
                        System.out.println("exiting HandlerFilterFunction");
                    }
                }).build();
    }
}
