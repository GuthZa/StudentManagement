package com.guthza.studentmanagement.manager;

import com.guthza.studentmanagement.repositories.StudentRepository;
import com.guthza.studentmanagement.users.Student;
import jakarta.persistence.Entity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.Optional;


//A Rest controller is ready to handle web requests
//Http get, post, put, delete
@RestController
public class ManagementController {

    private final StudentRepository studentRepository;

    public ManagementController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<String> getStudent(@PathVariable Long id)
    {
        Student student = studentRepository.retrieve(id);
        if(student!=null) {
            return new ResponseEntity<>(student.toString(),HttpStatus.OK);
        }
        return new ResponseEntity<>("Student with id " + id + " not found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/students")
    public Iterable<ResponseEntity<String>> getAll() {

    }
}
