package cn.elvea.samples.spring.boot.data.elasticsearch.repository;

import cn.elvea.samples.spring.boot.data.elasticsearch.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserElasticRepository extends PagingAndSortingRepository<User, Long> {
}
