package com.guthza.studentmanagement.courses;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Course {
    private String name;
    private int credits;
    private String teacherName;

    public Course(String name) {
        this.name = name;
        this.credits = 8;
        this.teacherName = "Gandalf";
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", credits=" + credits +
                ", teacherName='" + teacherName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return credits == course.credits && Objects.equals(name, course.name) && Objects.equals(teacherName, course.teacherName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, credits, teacherName);
    }
}
