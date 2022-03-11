package com.dependency2.Project2.Repository;


import com.dependency2.Project2.Entity.BooksInTheLibraryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksInTheLibraryRepository extends CrudRepository<BooksInTheLibraryEntity,Integer> {
}
