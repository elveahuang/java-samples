package cn.elvea.samples.spring.boot.data.jdbc.repository;

import cn.elvea.samples.spring.boot.data.jdbc.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJdbcRepository extends PagingAndSortingRepository<User, Long> {
}
