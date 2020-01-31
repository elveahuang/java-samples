package cn.elvea.samples.spring.boot.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(
        basePackages = {"cn.elvea.samples.spring.boot"}
)
public class Config {
}
