package com.neyaz.MappingPractice.Repository;

import com.neyaz.MappingPractice.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,String> {
}
