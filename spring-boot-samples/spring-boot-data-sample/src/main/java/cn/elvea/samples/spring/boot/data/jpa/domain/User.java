package cn.elvea.samples.spring.boot.data.jpa.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "sys_user")
public class User extends IdEntity implements Serializable {
    private String username;
    private String nickname;
    private Date createdAt;
}
