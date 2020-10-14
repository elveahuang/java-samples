package cn.elvea.spring.boot.oauth.server.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * AuthController
 *
 * @author elvea
 */
@Controller
public class AuthController {

    /**
     * 登录页面
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
