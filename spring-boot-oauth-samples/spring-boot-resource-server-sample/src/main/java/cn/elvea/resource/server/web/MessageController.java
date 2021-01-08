package cn.elvea.resource.server.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * MessageController
 *
 * @author elvea
 */
@Controller
@RequestMapping("/message")
public class MessageController {

    @GetMapping
    @ResponseBody
    public String getMessage() {
        return "Get Messgae";
    }

    @PostMapping
    @ResponseBody
    public String postMessage(String message) {
        return "Post Message - " + message;
    }

}
