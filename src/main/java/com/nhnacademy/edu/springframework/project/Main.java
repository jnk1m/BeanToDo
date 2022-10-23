package com.nhnacademy.edu.springframework.project;

import com.nhnacademy.edu.springframework.project.config.RepositoryConfig;
import com.nhnacademy.edu.springframework.project.service.DataLoadService;
import com.nhnacademy.edu.springframework.project.service.Student;
import com.nhnacademy.edu.springframework.project.service.StudentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Collection;

public class Main {

    // TODO 9 - 성공적으로 실행되어야 합니다.
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(RepositoryConfig.class);
        DataLoadService dataLoadServiceBean = ctx.getBean(DataLoadService.class);

        dataLoadServiceBean.loadAndMerge();

        StudentService studentService = ctx.getBean(StudentService.class);

        Collection<Student> passedStudents = studentService.getPassedStudents();
        System.out.println(passedStudents);


        Collection<Student> orderedStudents = studentService.getStudentsOrderByScore();
        System.out.println(orderedStudents);
    }
}
