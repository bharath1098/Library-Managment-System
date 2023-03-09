package com.example.Student_Library_Managment_Systems.Repository;

import com.example.Student_Library_Managment_Systems.Models.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card,Integer> {
}
