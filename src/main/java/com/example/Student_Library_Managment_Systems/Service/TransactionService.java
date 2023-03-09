package com.example.Student_Library_Managment_Systems.Service;

import com.example.Student_Library_Managment_Systems.DTOS.IssueBookReqDto;
import com.example.Student_Library_Managment_Systems.Enums.CardStatus;
import com.example.Student_Library_Managment_Systems.Enums.TransactionStatus;
import com.example.Student_Library_Managment_Systems.Models.Book;
import com.example.Student_Library_Managment_Systems.Models.Card;
import com.example.Student_Library_Managment_Systems.Models.Transaction;
import com.example.Student_Library_Managment_Systems.Repository.BookRepository;
import com.example.Student_Library_Managment_Systems.Repository.CardRepository;
import com.example.Student_Library_Managment_Systems.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    CardRepository cardRepository;
    public String issueBook(IssueBookReqDto issueBookReqDto) throws Exception{
        int bookId=issueBookReqDto.getBookId();
        int cardId=issueBookReqDto.getCardId();

        //get the book entity and card entiry
        Book book=bookRepository.findById(bookId).get();
        Card card=cardRepository.findById(cardId).get();

        //final goal is to make a transaction entity
        Transaction transaction=new Transaction();
        transaction.setBook(book);
        transaction.setCard(card);
        transaction.setTransactionId(UUID.randomUUID().toString());
        transaction.setIsissueOperation(true);
        transaction.setTransactionStatus(TransactionStatus.PENDING);

        // attribute left is success or failed
        //check for validity
        if(book==null || book.isIssued()==true){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Book is not available");
        }

        if(card==null || card.getCardStatus()!= CardStatus.ACTIVATED){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("card is not available");
        }

        //now we have reached the successfull stage
        transaction.setTransactionStatus(TransactionStatus.Success);

        book.setIssued(true);
        //here i need to make changes in card transaction also
        List<Transaction> cardTransactionList=card.getTransactionList();
        cardTransactionList.add(transaction);
        card.setTransactionList(cardTransactionList);


        //here i need to make chages in book transaction also
        List<Transaction> bookTransactionList=book.getListOfTransaction();
        bookTransactionList.add(transaction);
        book.setListOfTransaction(bookTransactionList);


        //here i need to make changes in book issued  also
        List<Book> bookIssuedforcard=card.getBookIssued();
        bookIssuedforcard.add(book);
        card.setBookIssued(bookIssuedforcard);

        //save the parent
       cardRepository.save(card);

       return "Book Issued Successfully";
    }


    public String getTransactionEntry(Integer bookId,Integer cardId){
         List<Transaction> list_transaction=transactionRepository.listtransactionforBookAndCard(bookId,cardId);
         return list_transaction.get(0).getTransactionId();
    }
}
