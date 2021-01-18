package cn.elvea.client.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * UserController
 *
 * @author elvea
 */
@Controller
public class UserController {

    @ResponseBody
    @RequestMapping("/user")
    public String user() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication);
        return authentication.getName();
    }

}
