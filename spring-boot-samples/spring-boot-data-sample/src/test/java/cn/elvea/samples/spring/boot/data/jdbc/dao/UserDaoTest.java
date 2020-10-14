package cn.elvea.samples.spring.boot.data.jdbc.dao;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * UserDaoTest
 *
 * @author elvea
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void test() {
        Assertions.assertNotNull(this.jdbcTemplate);

        List<Long> ids = this.jdbcTemplate.queryForList("select id from sys_activity_actor limit 1000;", Long.class);
        Assertions.assertNotNull(ids);

        String sql = " delete from sys_activity_actor where id in ( ";
        sql += StringUtils.join(ids, ",");
        sql += " ); ";
        System.out.println(sql);

        long t1 = System.currentTimeMillis();
//        this.jdbcTemplate.execute(sql);
        long t2 = System.currentTimeMillis();
        System.out.println("t2 - t1 = " + (t2 - t1));
        System.out.println("...");
    }

}
