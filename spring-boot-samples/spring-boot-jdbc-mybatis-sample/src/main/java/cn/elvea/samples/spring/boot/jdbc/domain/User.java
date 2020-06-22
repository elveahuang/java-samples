package cn.elvea.samples.spring.boot.jdbc.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.util.Date;

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

    @Transient
    Date getCurDate;

}
