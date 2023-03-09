package com.example.Student_Library_Managment_Systems.Controller;

import com.example.Student_Library_Managment_Systems.DTOS.IssueBookReqDto;
import com.example.Student_Library_Managment_Systems.Service.TransactionService;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Table(name = "transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;
    @PostMapping("issueBook")
    public String issueBook(@RequestBody IssueBookReqDto issueBookReqDto){
        try {
            return transactionService.issueBook(issueBookReqDto);
        }
        catch(Exception e){
            return e.getMessage();
        }
    }

    @GetMapping("getTxnInfo")
    public String getTransactionEntry(@RequestParam int bookId,@RequestParam int cardId){
        return transactionService.getTransactionEntry(bookId,cardId);
    }
}
