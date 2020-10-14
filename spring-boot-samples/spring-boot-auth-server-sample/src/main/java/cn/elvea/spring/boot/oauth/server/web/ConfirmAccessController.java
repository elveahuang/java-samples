package cn.elvea.spring.boot.oauth.server.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * ConfirmAccessController
 *
 * @author elvea
 */
@Controller
@SessionAttributes("authorizationRequest")
public class ConfirmAccessController {

    /**
     * 自定义确认授权页面
     */
    @RequestMapping("/oauth/confirm_access")
    public String getAccessConfirmation() {
        return "confirm_access";
    }

    /**
     * 自定义授权错误页面
     */
    @RequestMapping("/oauth/error")
    public String getError() {
        return "error";
    }

}
