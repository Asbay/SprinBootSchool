package com.example.repository;



import com.example.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {


    boolean existsByStudentNo(String studentNo);

    Optional<Object> findByStudentNo(String studentNo);


}
