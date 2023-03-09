package com.example.Student_Library_Managment_Systems.Controller;

import com.example.Student_Library_Managment_Systems.DTOS.StudentUpdateMobRequestDto;
import com.example.Student_Library_Managment_Systems.Models.Student;
import com.example.Student_Library_Managment_Systems.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController{

    @Autowired
    StudentService studentService;
    @PostMapping("/add")
    public String createStudent(@RequestBody Student student){

        return studentService.createStudent(student);

    }
   @GetMapping("/get_user")
    public String getNameByEmail(@RequestParam("email") String email){
        return studentService.getNameByEmail(email);
   }

   @PutMapping("update_mob")
    public String updateMob(@RequestBody StudentUpdateMobRequestDto studentUpdateMobRequestDto){
        return  studentService.updateMob(studentUpdateMobRequestDto);
   }

}

