package cn.elvea.samples.spring.boot.data.shardingsphere;

import org.apache.shardingsphere.api.hint.HintManager;
import org.apache.shardingsphere.shardingjdbc.jdbc.core.datasource.MasterSlaveDataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 读写分离单元测试
 *
 * @author elvea
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("shardingsphere")
public class ShardingSphereTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void test() {
        Assertions.assertNotNull(dataSource);
        Assertions.assertTrue(dataSource instanceof MasterSlaveDataSource);

        HintManager hintManager = HintManager.getInstance();
        hintManager.setMasterRouteOnly();
        System.out.println(this.jdbcTemplate.update(" delete from `sys_user` where `id` = 2 "));
        System.out.println(this.jdbcTemplate.update(" INSERT INTO `sys_user` (`id`, `username`, `email`, `mobile`,\n" +
                "                        `nickname`, `status`, `active`, `password`,\n" +
                "                        `created_at`, `created_by`, `modified_at`, `modified_by`)\n" +
                "VALUES (2, 'admin', 'master@host.com', '13800138000', 'Administrator', 1, 1,\n" +
                "        '$2a$10$NCaQsuUAmjMGYpDFCexkDumlA7aexspqelQews287jBk0cF5koypy',\n" +
                "        now(), 1, now(), 1); "));
        this.jdbcTemplate.query(" select `id` from `sys_user` ", new ResultSetExtractor<Object>() {
            @Override
            public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
                return null;
            }
        });
    }

}
