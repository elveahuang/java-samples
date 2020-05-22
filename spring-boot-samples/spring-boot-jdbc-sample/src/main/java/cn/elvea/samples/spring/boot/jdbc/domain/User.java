package cn.elvea.samples.spring.boot.jdbc.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;

/**
 * User
 *
 * @author elvea
 */
@Data
@NoArgsConstructor
@Table("sys_user")
public class User implements Serializable {

    @Id
    private Long id;

    @Column
    private String username;

    public User(Long id, String username) {
        this.id = id;
        this.username = username;
    }

}
