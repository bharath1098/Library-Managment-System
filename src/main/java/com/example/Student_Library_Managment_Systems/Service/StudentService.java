package com.example.Student_Library_Managment_Systems.Service;

import com.example.Student_Library_Managment_Systems.DTOS.StudentUpdateMobRequestDto;
import com.example.Student_Library_Managment_Systems.Enums.CardStatus;
import com.example.Student_Library_Managment_Systems.Models.Card;
import com.example.Student_Library_Managment_Systems.Models.Student;
import com.example.Student_Library_Managment_Systems.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public String createStudent(Student student){

        //Already the basic attribute set for student from the postman
        //Card should be auto-generated when createstudent function is called so
        Card card=new Card();
        card.setCardStatus(CardStatus.ACTIVATED);
        card.setStudent(student);

        student.setCard(card);

        studentRepository.save(student);
        return "Student has been Created";
    }

    public String getNameByEmail(String email){
        Student student=studentRepository.findByEmail(email);
        return student.getName();
    }

    public  String updateMob(StudentUpdateMobRequestDto studentUpdateMobRequestDto){
        Student student=studentRepository.findById(studentUpdateMobRequestDto.getId()).get();
        student.setMobNo(studentUpdateMobRequestDto.getMobNo());
        studentRepository.save(student);
        return "mobile number has been updated";

    }
}