package cn.elvea.samples.spring.boot.data.web;

import cn.elvea.samples.spring.boot.data.jdbc.domain.User;
import cn.elvea.samples.spring.boot.data.jdbc.repository.UserJdbcRepository;
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
    UserJdbcRepository userRepository;

    @ResponseBody
    @RequestMapping({"/find-by-username"})
    public User index() {
        return null;
    }

}
