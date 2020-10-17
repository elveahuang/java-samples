package cn.elvea.samples.spring.boot.data.jpa.domain;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Data
@MappedSuperclass
public abstract class IdEntity implements Serializable {
    @Id
    private Long id;
}
