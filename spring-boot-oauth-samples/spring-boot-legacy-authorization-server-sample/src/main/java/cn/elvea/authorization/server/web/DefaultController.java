package cn.elvea.authorization.server.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 默认控制器
 *
 * @author elvea
 */
@Controller
public class DefaultController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

}
