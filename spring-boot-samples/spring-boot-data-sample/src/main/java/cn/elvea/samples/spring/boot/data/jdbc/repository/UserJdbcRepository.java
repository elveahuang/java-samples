package cn.elvea.samples.spring.boot.data.jdbc.repository;

import cn.elvea.samples.spring.boot.data.jdbc.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRepository
 *
 * @author elvea
 */
@Repository
public interface UserJdbcRepository extends CrudRepository<User, Long> {
}
