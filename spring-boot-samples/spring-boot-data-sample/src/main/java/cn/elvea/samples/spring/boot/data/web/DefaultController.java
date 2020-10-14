package cn.elvea.samples.spring.boot.data.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
