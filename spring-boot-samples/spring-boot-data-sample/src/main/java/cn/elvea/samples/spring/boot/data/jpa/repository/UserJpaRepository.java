package cn.elvea.samples.spring.boot.data.jpa.repository;

import cn.elvea.samples.spring.boot.data.jpa.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends PagingAndSortingRepository<User, Long> {
}
