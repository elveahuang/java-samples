package cn.elvea.quarkus.base.service;

import javax.enterprise.context.ApplicationScoped;

/**
 * CoreService
 *
 * @author elvea
 */
@ApplicationScoped
public class CoreService {

    public String hello() {
        return "Hello World";
    }

}
