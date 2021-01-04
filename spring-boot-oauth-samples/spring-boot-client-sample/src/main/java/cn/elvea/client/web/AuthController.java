package cn.elvea.client.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * AuthorizationController
 *
 * @author elvea
 */
@Controller
public class AuthController {

    @GetMapping("/authorized")
    public String home() {
        return "home";
    }

}
