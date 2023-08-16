package com.guthza.studentmanagement.service;

import com.guthza.studentmanagement.repositories.StudentRepository;
import com.guthza.studentmanagement.users.Student;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }




}
