package com.abhave.student.dal;

import com.abhave.student.dal.entities.Student;
import com.abhave.student.dal.repos.StudentRepository;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentdalApplicationTests {

    @Autowired
    private StudentRepository studentRepository;

    @Test
   public void testCreateStudent() {

        Student student = new Student();
        student.setName("Abhijit");
        student.setCourse("ACS");
        student.setFees(3000.00);

        studentRepository.save(student);
        System.out.println("Done");
   }

   @Test
    public void testReadStudent() {
        Long id = 3l;
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent())
            System.out.println(student.get());


   }


    @Test
    public void testUpdateStudent() {
        //Long id = 3l;
        Optional<Student> studentOptional = studentRepository.findById(3l);
        if(studentOptional.isPresent()) {
            Student student = studentOptional.get();
            student.setFees(400.00);
            studentRepository.save(student);
        }


    }

    @Test
    public void testDeleteStudent() {
        Optional<Student> studentOptional = studentRepository.findById(1l);
        if(studentOptional.isPresent())
        {
            Student student = studentOptional.get();
            studentRepository.delete(student);
        }
    }
}
