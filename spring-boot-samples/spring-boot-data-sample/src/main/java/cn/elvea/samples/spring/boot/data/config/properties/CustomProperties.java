package cn.elvea.samples.spring.boot.data.config.properties;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@NoArgsConstructor
@ConfigurationProperties(prefix = "app")
public class CustomProperties {
    /**
     * 是否启用读写分离
     */
    private boolean masterSlaveEnable = false;
}
