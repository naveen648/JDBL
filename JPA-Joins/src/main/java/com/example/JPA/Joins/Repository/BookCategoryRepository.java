package com.example.JPA.Joins.Repository;

import com.example.JPA.Joins.Models.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCategoryRepository extends JpaRepository<BookCategory,Integer> {
}

