package com.example.Student_Library_Managment_Systems.Controller;

import com.example.Student_Library_Managment_Systems.DTOS.AuthorEntryDto;
import com.example.Student_Library_Managment_Systems.DTOS.AuthorResponseDto;
import com.example.Student_Library_Managment_Systems.Models.Author;
import com.example.Student_Library_Managment_Systems.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("author")
public class AuthorController {
    @Autowired
    AuthorService authorService;
    @PostMapping("/add")
    public String addAuthor(@RequestBody AuthorEntryDto author){
        return authorService.addAuthor(author);
    }

    @GetMapping("/getAuthor")
    public AuthorResponseDto getAuthor(@RequestParam("authorId") Integer authorId){
        return authorService.getAuthor(authorId);
    }




}