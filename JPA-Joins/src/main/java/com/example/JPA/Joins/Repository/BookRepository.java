package com.example.JPA.Joins.Repository;

import com.example.JPA.Joins.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
//    List<Book> findById(int id);

//    Book findById(int id);
//    List<Book> findByAuthorName(String name);
//    List<Book> findByName(String name);
//    List<Book> findByCost(int cost);

//    @Query(value="select * from book b where b.author_name=:authname",nativeQuery = true)
//    List<Book> findByAuthor(String authname);
}
