package com.example.Student_Library_Managment_Systems.Repository;

import com.example.Student_Library_Managment_Systems.Models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
    @Query(value ="select * from transaction as t where t.book_id=:bookId and t.card_id=:cardId and isissue_operation=true",nativeQuery = true)
    List<Transaction> listtransactionforBookAndCard(Integer bookId,Integer cardId);
}
