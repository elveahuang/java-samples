package cn.elvea.samples.spring.mvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(
        basePackages = {"cn.elvea.samples.spring.mvc"}
)
public class Config {
}
