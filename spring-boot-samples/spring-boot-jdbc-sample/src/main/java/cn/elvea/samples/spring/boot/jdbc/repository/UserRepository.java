package cn.elvea.samples.spring.boot.jdbc.repository;

import cn.elvea.samples.spring.boot.jdbc.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * UserRepository
 *
 * @author elvea
 */
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
}
