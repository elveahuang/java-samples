package cn.elvea.samples.spring.boot.jdbc.web;

import cn.elvea.samples.spring.boot.jdbc.dao.UserDao;
import cn.elvea.samples.spring.boot.jdbc.domain.User;
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
    UserDao userDao;

    @ResponseBody
    @RequestMapping({"/find-by-username"})
    public User index() {
        return this.userDao.findByUsername("admin");
    }

}
