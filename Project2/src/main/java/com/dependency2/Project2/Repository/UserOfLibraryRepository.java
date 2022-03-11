package com.dependency2.Project2.Repository;
import com.*;
import com.dependency2.Project2.Entity.UserOfLibraryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserOfLibraryRepository extends CrudRepository<UserOfLibraryEntity,Integer> {

}

