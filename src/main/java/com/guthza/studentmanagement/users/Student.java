package com.guthza.studentmanagement.users;

import com.guthza.studentmanagement.courses.Course;
import lombok.Getter;
import lombok.Setter;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
public class Student {

    private static final AtomicInteger _ID = new AtomicInteger(0);

    private final int id;
    private String firstName;
    private String lastName;
    @Getter
    private List<Course> courseList = new ArrayList<>();

    public Student(String firstName, String lastName) {
        this.id = _ID.incrementAndGet();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public boolean addCourseByName(String name) {
        Course courseToAdd = new Course(name);
        if (courseList.contains(courseToAdd)) return false;
        return courseList.add(courseToAdd);
    }

    public boolean removeCourseByName(String name) {
        Course courseToRemove = new Course(name);
        return courseList.contains(courseToRemove) && courseList.remove(courseToRemove);
    }

    @Override
    public String toString() {
        return "Student{" +
                "uniqueID='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", classes=" + courseList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) &&
                Objects.equals(firstName, student.firstName) &&
                Objects.equals(lastName, student.lastName) &&
                Objects.equals(courseList, student.courseList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, courseList);
    }
}
