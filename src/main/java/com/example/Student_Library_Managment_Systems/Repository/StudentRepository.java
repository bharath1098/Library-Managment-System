package com.example.Student_Library_Managment_Systems.Repository;

import com.example.Student_Library_Managment_Systems.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    Student findByEmail(String email);
}
