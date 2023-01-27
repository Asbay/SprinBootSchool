package com.example.dto;

import com.example.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    @NotNull(message = "First name can not be null")
    @NotBlank(message = "First name can not be space")
    @Size(min = 2, max = 50)
    private String name;

    @NotNull(message = "Last name can not be null")
    @NotBlank(message = "Last name can not be space")
    @Size(min = 2, max = 50)
    private String lastName;


/*
public CustomerDTO(Customer customer){
        this.name=customer.getName();
        this.lastName=customer.getLastName();
        this.email= customer.getEmail();
        this.phone= customer.getPhone();
    }
 */
   @NotNull(message="First studentNo can not be null!")
   @NotBlank(message = "First studentNo can not be white space")
    private String studentNo;

    private String grade;

    public StudentDTO(Student student) {
        this.name = student.getName();
        this.lastName = student.getLastName();
        this.studentNo = student.getStudentNo();
        this.grade = student.getGrade();
    }
}