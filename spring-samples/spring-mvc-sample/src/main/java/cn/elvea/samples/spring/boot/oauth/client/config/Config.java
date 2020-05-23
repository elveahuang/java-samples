package cn.elvea.samples.spring.boot.oauth.client.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(
        basePackages = {"cn.elvea.samples.spring.boot"},
        excludeFilters = {@ComponentScan.Filter(Controller.class)}
)
public class Config {
}
