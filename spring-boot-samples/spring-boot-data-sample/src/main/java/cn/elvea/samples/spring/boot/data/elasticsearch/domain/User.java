package cn.elvea.samples.spring.boot.data.elasticsearch.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@Document(indexName = "java-samples-spring-data-user")
public class User implements Serializable {
    @Id
    private Long id;
    private String username;
    private String nickname;
    private Date createdAt;
}
