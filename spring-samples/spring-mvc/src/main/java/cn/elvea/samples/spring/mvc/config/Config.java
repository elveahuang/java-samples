package cn.elvea.samples.spring.mvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(
        basePackages = {"cn.elvea.samples.spring.mvc"},
        excludeFilters = {@ComponentScan.Filter(Controller.class)}
)
public class Config {
}
