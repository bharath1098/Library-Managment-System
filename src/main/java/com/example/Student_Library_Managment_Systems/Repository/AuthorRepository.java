package com.example.Student_Library_Managment_Systems.Repository;

import com.example.Student_Library_Managment_Systems.Models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
}
