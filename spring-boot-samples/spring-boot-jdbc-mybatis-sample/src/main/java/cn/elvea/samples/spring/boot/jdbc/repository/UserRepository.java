package cn.elvea.samples.spring.boot.jdbc.repository;

import cn.elvea.samples.spring.boot.jdbc.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRepository
 *
 * @author elvea
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
