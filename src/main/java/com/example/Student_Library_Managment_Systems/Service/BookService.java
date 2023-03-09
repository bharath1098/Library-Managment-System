package com.example.Student_Library_Managment_Systems.Service;

import com.example.Student_Library_Managment_Systems.DTOS.BookRequestDto;
import com.example.Student_Library_Managment_Systems.Models.Author;
import com.example.Student_Library_Managment_Systems.Models.Book;
import com.example.Student_Library_Managment_Systems.Repository.AuthorRepository;
import com.example.Student_Library_Managment_Systems.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;
    public String addBook(BookRequestDto bookRequestDto){


        //I want to get the author entity
        int authorId=bookRequestDto.getAuthorId();

        //now i will fetch author entity
        Author author=authorRepository.findById(authorId).get();

        //convert Dto to entity
        Book book=new Book();

        //Basic attributes are being from dto to the entity layer
        book.setName(bookRequestDto.getName());
        book.setPages(bookRequestDto.getPages());
        book.setGenre(bookRequestDto.getGenre());
        book.setIssued(false);

        book.setAuthor(author);

        List<Book> currentBookWritten=author.getBookList();
        currentBookWritten.add(book);
        author.setBookList(currentBookWritten);

        authorRepository.save(author);

        return "Book added succesfully";
    }
}
