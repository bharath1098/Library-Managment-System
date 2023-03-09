package com.example.Student_Library_Managment_Systems.Models;

import com.example.Student_Library_Managment_Systems.Enums.Genre;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int pages;
    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    private boolean issued;

    public boolean isIssued() {
        return issued;
    }

    public void setIssued(boolean issued) {
        this.issued = issued;
    }

    //Book - Author(parent)  mapping
    @ManyToOne
    @JoinColumn
    private Author author;
    // Book - card(parent) mapping
    @ManyToOne
    @JoinColumn
    private Card card;

    //biDirectional mapping
    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    private List<Transaction> listOfTransaction=new ArrayList<>();

    public List<Transaction> getListOfTransaction() {
        return listOfTransaction;
    }

    public void setListOfTransaction(List<Transaction> listOfTransaction) {
        this.listOfTransaction = listOfTransaction;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
