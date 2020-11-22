package com.picsart.Lesson6.service;

import com.picsart.Lesson6.model.Student;


public class StudentService {


    //TODO     Task 1: Print full names of students
    public void getFullNames(Student[] students) {
        for (Student student : students) {
            System.out.println(student.getFirstName() + " " + student.getLastName());
        }
    }


    //TODO     Task 2: Print all male students
    public void getMaleStudents(Student[] students) {
        for (Student student : students) {
            if ('m' == student.getGender()) {
                System.out.println(student.toString());
            }
        }
    }

    //TODO     Task 3: Print all female students who has mark greater then 50.4
    public void getStudentsByGenderAndMark(Student[] students) {
        for (Student student : students) {
            if ('f' == student.getGender() && student.getMark() >= 50.4) {
                System.out.println(student.toString());
            }
        }
    }

    //TODO     Task 4: Print student information having the minimal mark
    public void getStudentWithMinMark(Student[] students) {
        Double minMark = students[0].getMark();
        for (int i = 1; i < students.length; i++) {
            if (minMark >= students[i].getMark()) {
                minMark = students[i].getMark();
                System.out.println(students[i]);
            }

        }
    }

    //TODO     Task 5: Print biggest male student information
    public void getOlderMaleStudent(Student[] students) {


        Student[] maleStudents = filterByGender(students, 'm');
        int count = maleStudents.length;

        //sort array
        for (int i = 0; i <= count; i++) {
            for (int j = i + 1; j < count; j++) {
                if (maleStudents[i].getYear() >= maleStudents[j].getYear()) {
                    swap(maleStudents, i, j);
                }
            }
        }

        System.out.println(maleStudents[0].getFirstName());

        //students that have th same year
        for (int i = 0; i < count - 1; i++) {
            if (maleStudents[0].getYear().equals(maleStudents[i + 1].getYear())) {
                System.out.println(maleStudents[i + 1].getFirstName());
            }
        }

    }


    //TODO     Task 6: Print students sorted by mark
    public void getStudentsByMark(Student[] students) {
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = 0; j < students.length - i - 1; j++) {
                if (students[j + 1].getMark() <= students[j].getMark()) {
                    swap(students, j, j + 1);
                }
            }

        }
        printStudentArray(students);
    }


    //TODO     Task 7: Print female students sorted by year
    public void getFemaleStudentSortByYear(Student[] students) {

        Student[] femaleStudents = filterByGender(students, 'f');

        for (int i = 0; i <= femaleStudents.length; i++) {
            for (int j = i + 1; j < femaleStudents.length; j++) {
                if (femaleStudents[i].getYear() >= femaleStudents[j].getYear()) {
                    swap(femaleStudents, i, j);
                }
            }
        }

        printStudentArray(femaleStudents);
    }


    public static void swap(Student[] array, int i, int j) {
        Student temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void printStudentArray(Student[] students) {
        for (Student student : students) {
            System.out.println(student.toString());

        }
    }

    public static Student[] filterByGender(Student[] students, char gender) {
        int count = 0;
        Student[] ss = new Student[students.length];

        for (Student student : students) {
            if (gender == student.getGender()) {
                ss[count] = student;
                ++count;
            }
        }
        Student[] genderS = new Student[count];
        for (int i = 0; i < count; i++) {
            genderS[i] = ss[i];
        }
        return genderS;
    }

}
