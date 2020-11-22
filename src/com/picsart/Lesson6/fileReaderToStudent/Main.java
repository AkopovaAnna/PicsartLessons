package com.picsart.Lesson6.fileReaderToStudent;


import com.picsart.Lesson6.fileReaderToStudent.model.Student;
import com.picsart.Lesson6.fileReaderToStudent.service.StudentService;
import com.picsart.Lesson6.fileReaderToStudent.utils.FileProvider;
import com.picsart.Lesson6.fileReaderToStudent.utils.FileToStudentConverter;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        //give file path here
        String path = "C:\\Users\\user\\Documents\\students.txt";

        StudentService ss = new StudentService();

        try {
            String[] fileContentLines = FileProvider.readFileContent(path);
            Student[] studentList = FileToStudentConverter.fileContentToStudent(fileContentLines);

            System.out.println("----Full Names----");
            ss.getFullNames(studentList);
            System.out.println("==================");

            System.out.println("----male students----");
            ss.getMaleStudents(studentList);
            System.out.println("==================");

            System.out.println("----female students----");
            ss.getStudentsByGenderAndMark(studentList);
            System.out.println("==================");

            System.out.println("----min mark student----");
            ss.getStudentWithMinMark(studentList);
            System.out.println("==================");

            System.out.println("----biggest male student----");
            ss.getOlderMaleStudent(studentList);
            System.out.println("==================");

            System.out.println("----sorted by mark----");
            ss.getStudentsByMark(studentList);
            System.out.println("======================");

            System.out.println("----female students by year----");
            ss.getFemaleStudentSortByYear(studentList);
            System.out.println("=========");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
