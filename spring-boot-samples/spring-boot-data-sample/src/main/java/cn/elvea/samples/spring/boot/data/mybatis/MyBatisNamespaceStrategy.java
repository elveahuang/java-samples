package cn.elvea.samples.spring.boot.data.mybatis;


import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jdbc.mybatis.NamespaceStrategy;

/**
 * MyBatisNamespaceStrategy
 *
 * @author elvea
 */
@Slf4j
public class MyBatisNamespaceStrategy implements NamespaceStrategy {

    @Override
    public String getNamespace(Class<?> domainType) {
//        String namespace = "cn.elvea.samples.spring.boot.jdbc.mapper.".concat(domainType.getSimpleName()).concat("Mapper");
        String namespace = "cn.elvea.samples.spring.boot.jdbc.repository.".concat(domainType.getSimpleName()).concat("Repository");
        log.debug("namespace for [{}] is [{}].", domainType.getName(), namespace);
        return namespace;
    }

}
