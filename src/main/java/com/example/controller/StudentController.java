package com.example.controller;

import com.example.domain.Student;
import com.example.dto.StudentDTO;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping  //http://localhost:8088/students
    public ResponseEntity<String> saveStudent(@Valid @RequestBody Student student){
        studentService.saveStudent(student);
        return ResponseEntity.ok("Creating is successfuly");
    }


    //b)ögrenciler notlarini degistirebilsin
    @PutMapping("{studentNo}") // http://localhost:8088/students/11111  + PUT + JSON
    public ResponseEntity<String> updateGrade(@PathVariable("studentNo") String studentNo, @Valid @RequestBody StudentDTO studentDTO) {
        studentService.updateGrade(studentNo,studentDTO);

        return ResponseEntity.ok("Grade is updated successfuly");
    }

    @GetMapping("/List")   //http://localhost:8088/students/List
    public ResponseEntity<List<Student>> getAllList(){
        List<Student> list1 = studentService.getAllList();
        return ResponseEntity.ok(list1);
    }

    //Her ogrenci kendi numarasini girerek kendi notunu görüntüleyebilsin.
    @GetMapping("{studentNo}")// http://localhost:8088/students/querystudentno
    public ResponseEntity<Student> getStudentByStudentNo(@PathVariable("studentNo") String studentNo){
        Student student=  studentService.findStudentNo(studentNo);
        return ResponseEntity.ok(student);
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllStudent(){
        List<StudentDTO> students = studentService.getAllStudent();
        return ResponseEntity.ok(students);

    }





}
