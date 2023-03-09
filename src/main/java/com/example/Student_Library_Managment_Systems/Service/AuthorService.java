package com.example.Student_Library_Managment_Systems.Service;

import com.example.Student_Library_Managment_Systems.DTOS.AuthorEntryDto;
import com.example.Student_Library_Managment_Systems.DTOS.AuthorResponseDto;
import com.example.Student_Library_Managment_Systems.DTOS.BookResponseDto;
import com.example.Student_Library_Managment_Systems.Models.Author;
import com.example.Student_Library_Managment_Systems.Models.Book;
import com.example.Student_Library_Managment_Systems.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;
    public String addAuthor(@RequestBody AuthorEntryDto authorEntryDto){
        Author author=new Author();
        //we are setting its attributes so that we can save correct values in the db
        author.setName(authorEntryDto.getName());
        author.setAge(authorEntryDto.getAge());
        author.setCountry(authorEntryDto.getCountry());
        author.setRating(authorEntryDto.getRating());
        authorRepository.save(author);
        return "Author added Successfully";
    }

    public AuthorResponseDto getAuthor(Integer authorId){
        Author author=authorRepository.findById(authorId).get();
        AuthorResponseDto authorResponseDto=new AuthorResponseDto();

        //set its attributes.
        //list<book> --> list<BookResponseDto>

        List<Book> bookList=author.getBookList();

        List<BookResponseDto> bookWrittenDto=new ArrayList<>();

        for(Book b:bookList){
            BookResponseDto bookResponseDto=new BookResponseDto();
            //name page genre
            bookResponseDto.setName(b.getName());
            bookResponseDto.setPages(b.getPages());
            bookResponseDto.setGenre(b.getGenre());
            bookWrittenDto.add(bookResponseDto);
        }

        authorResponseDto.setName(author.getName());
        authorResponseDto.setAge(author.getAge());
        authorResponseDto.setCountry(author.getCountry());
        authorResponseDto.setRating(author.getRating());
        authorResponseDto.setBooksWritten(bookWrittenDto);

        return authorResponseDto;
    }
}
