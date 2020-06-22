package cn.elvea.samples.spring.boot.jdbc.web;

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

    @ResponseBody
    @RequestMapping({"/json"})
    public String json() {
        return "index";
    }

}
