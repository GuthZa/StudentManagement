package com.guthza.studentmanagement.manager;

import com.guthza.studentmanagement.repositories.StudentRepository;
import com.guthza.studentmanagement.users.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//A Rest controller is ready to handle web requests
//Http get, post, put, delete
@RestController
@RequestMapping("/students")
public class ManagementController {

    private final StudentRepository studentRepository;

    public ManagementController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getStudent(@PathVariable Long id)
    {
        Student student = studentRepository.retrieve(id);
        if(student!=null) {
            return new ResponseEntity<>(student.toString(),HttpStatus.OK);
        }
        return new ResponseEntity<>("Student with id " + id + " not found", HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<String> getAllStudents() {
        return new ResponseEntity<>("all students!", HttpStatus.OK);
    }
}
