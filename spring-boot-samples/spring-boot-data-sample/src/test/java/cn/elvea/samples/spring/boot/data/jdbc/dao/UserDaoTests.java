package cn.elvea.samples.spring.boot.data.jdbc.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

/**
 * UserDaoTest
 *
 * @author elvea
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserDaoTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void test() {
        Assertions.assertNotNull(this.jdbcTemplate);
        List<Long> ids = this.jdbcTemplate.queryForList("select id from sys_user limit 1000;", Long.class);
        Assertions.assertNotNull(ids);
    }

}
