package com.guthza.studentmanagement.repositories;

import com.guthza.studentmanagement.users.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepository implements ObjectRepository<Student> {

    //change to db
    private Map<Long, Student> repository;

    public StudentRepository() {
        this.repository = new HashMap<>();
    }

    @Override
    public void store(Student student) {
        repository.put(student.getId(), student);
    }

    @Override
    public Student retrieve(Long id) {
        return repository.get(id);
    }

    @Override
    public Student search(String name) {
        Collection<Student> students = repository.values();
        for(Student student : students) {
            if(student.getName().equalsIgnoreCase(name)){
                return student;
            }
        }
        return null;
    }

    @Override
    public Student delete(Long id) {
        return null;
    }
}
