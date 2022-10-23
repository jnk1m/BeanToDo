package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.service.Student;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CsvStudents implements Students {

    List<Student> studentList = new ArrayList<>();

    // TODO 7 : student.csv 파일에서 데이터를 읽어 클래스 멤버 변수에 추가하는 로직을 구현하세요.
    // 데이터를 적재하고 읽기 위해서, 적절한 자료구조를 사용하세요.
    @Override
    public void load() {
        String[] line;
        String path = "src/main/resources/data/student.csv";

        try(CSVReader csvReader = new CSVReader(new FileReader(path));){
            while ((line = csvReader.readNext()) != null) {
                studentList.add(new Student(Integer.parseInt(line[0]),line[1]));
            }
        } catch (CsvException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Collection<Student> findAll() {
        return studentList;
    }

    /**
     * TODO 8 : students 데이터에 score 정보를 추가하세요.
     * @param scores
     */
    @Override
    public void merge(Collection<Score> scores) {
       for(Student student : studentList){
           for(Score score: scores){
               if(student.getSeq() == score.getStudentSeq()){
                   student.setScore(score);
               }
           }
       }

    }
}
