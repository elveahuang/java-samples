package cn.elvea.authorization.server.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AuthController
 *
 * @author elvea
 */
@RestController
public class DefaultController {

    @GetMapping("/")
    public String login() {
        return "Hello World!";
    }

}
