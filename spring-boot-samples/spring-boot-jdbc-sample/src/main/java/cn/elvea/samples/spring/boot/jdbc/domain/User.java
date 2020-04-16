package cn.elvea.samples.spring.boot.jdbc.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User
 *
 * @author elvea
 */
@Data
@NoArgsConstructor
public class User {
    private Long id;
    private String username;

    public User(Long id, String username) {
        this.id = id;
        this.username = username;
    }
}
