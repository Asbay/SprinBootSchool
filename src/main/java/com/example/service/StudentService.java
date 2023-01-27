package com.example.service;

import com.example.domain.Student;
import com.example.dto.StudentDTO;
import com.example.exception.ConflictException;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    public void saveStudent(Student student) {
        if (studentRepository.existsByStudentNo(student.getStudentNo())){
            throw new ConflictException("Student no already exists!");
        }
        studentRepository.save(student);
    }


    public Student getStudentByStudentNo(String studentNo){
        Student student= (Student) studentRepository.findByStudentNo(studentNo).
                orElseThrow(()->new ResourceNotFoundException("Student not found by studentNo: "+studentNo));
        return student;
    }

    public void updateGrade(String studentNo, StudentDTO studentDTO) {

        Student student = getStudentByStudentNo(studentNo);
         student.setGrade(studentDTO.getGrade()); // sadece notunu degistirdik
        studentRepository.save(student); //sadece not degistirdi digerleri ayni
       ;

    }
    public Student findStudentNo(String studentNo) {
        return (Student) studentRepository.findByStudentNo(studentNo).orElseThrow(()->new ResourceNotFoundException("Student is not found"));
    }


    public List<Student> getAllList() {
       return studentRepository.findAll();

    }
    public List<StudentDTO> getAllStudent() {
        List<Student> list = studentRepository.findAll();
        List<StudentDTO> listDTO = new ArrayList<>();
        for (Student s : list) {
            listDTO.add(new StudentDTO(s));
        }
        return listDTO;
    }
}
