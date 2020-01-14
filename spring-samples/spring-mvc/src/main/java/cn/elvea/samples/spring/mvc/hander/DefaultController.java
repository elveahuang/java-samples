package cn.elvea.samples.spring.mvc.hander;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {

    @RequestMapping({"/"})
    public String index() {
        return "index";
    }

}
