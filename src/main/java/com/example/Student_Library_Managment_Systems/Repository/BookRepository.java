package com.example.Student_Library_Managment_Systems.Repository;

import com.example.Student_Library_Managment_Systems.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
