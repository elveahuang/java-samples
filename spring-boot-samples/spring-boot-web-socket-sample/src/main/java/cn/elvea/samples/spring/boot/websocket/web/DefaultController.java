package cn.elvea.samples.spring.boot.websocket.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * DefaultController
 *
 * @author elvea
 */
@Controller
public class DefaultController {

    @RequestMapping({"/"})
    public String index() {
        return "index";
    }

    @RequestMapping({"/home"})
    public String home() {
        return "home";
    }

    @ResponseBody
    @RequestMapping({"/json"})
    public String json() {
        return "index";
    }

}
