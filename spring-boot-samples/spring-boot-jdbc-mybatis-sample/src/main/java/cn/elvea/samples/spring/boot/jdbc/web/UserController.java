package cn.elvea.samples.spring.boot.jdbc.web;

import cn.elvea.samples.spring.boot.jdbc.domain.User;
import cn.elvea.samples.spring.boot.jdbc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * UserController
 *
 * @author elvea
 */
@Controller
@RequestMapping({"/user"})
public class UserController {

    @Autowired
    UserRepository userRepository;

    @ResponseBody
    @RequestMapping({"/find-by-username"})
    public User index() {
        return null;
    }

}
