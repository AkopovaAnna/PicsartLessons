package com.picsart.Lesson6.utils;

import com.picsart.Lesson6.model.Student;

public class FileToStudentConverter {

    public static Student[] fileContentToStudent(String[] lines) {

        Student[] students = new Student[lines.length];

        for (int i = 0; i < lines.length; i++) {
            String[] tokens = lines[i].split(",");

            students[i] = createStudent(tokens);

        }
        return students;
    }

    public static Student createStudent(String[] tokens) {
        Student student = new Student();
        student.setFirstName(tokens[0]);
        student.setLastName(tokens[1]);
        student.setYear(Integer.parseInt(tokens[2]));
        student.setGender(tokens[3].charAt(0));
        student.setMark(Double.parseDouble(tokens[4]));
        return student;
    }

}
