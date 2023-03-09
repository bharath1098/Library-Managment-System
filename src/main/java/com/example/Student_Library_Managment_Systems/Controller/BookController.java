package com.example.Student_Library_Managment_Systems.Controller;

import com.example.Student_Library_Managment_Systems.DTOS.BookRequestDto;
import com.example.Student_Library_Managment_Systems.Models.Book;
import com.example.Student_Library_Managment_Systems.Service.BookService;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Table(name = "book")
public class BookController {
    @Autowired
    BookService bookService;
    @PostMapping("/add")
    public String addBook(@RequestBody BookRequestDto bookRequestDto){
        return  bookService.addBook(bookRequestDto);
    }

}