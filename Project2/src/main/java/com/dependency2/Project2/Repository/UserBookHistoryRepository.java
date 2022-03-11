package com.dependency2.Project2.Repository;

import com.dependency2.Project2.Entity.UserBookHistoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBookHistoryRepository extends CrudRepository<UserBookHistoryEntity, Integer> {
}
