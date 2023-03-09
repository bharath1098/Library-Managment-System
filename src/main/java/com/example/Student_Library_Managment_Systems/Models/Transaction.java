package com.example.Student_Library_Managment_Systems.Models;

import com.example.Student_Library_Managment_Systems.Enums.TransactionStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(value = EnumType.STRING)
    private TransactionStatus transactionStatus;

    private int fine;
    private String transactionId= UUID.randomUUID().toString();
    @CreationTimestamp
    private Date transactionDate;

    private boolean isissueOperation;

    //we need to connect book(parent) and transaction
    @ManyToOne
    @JoinColumn
    private Book book;
    //we need to connect card(parent) and transaction
    @ManyToOne
    @JoinColumn
    private Card card;


    public Transaction() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public boolean isIsissueOperation() {
        return isissueOperation;
    }

    public void setIsissueOperation(boolean isissueOperation) {
        this.isissueOperation = isissueOperation;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
