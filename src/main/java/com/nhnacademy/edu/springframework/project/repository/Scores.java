package com.nhnacademy.edu.springframework.project.repository;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface Scores {
    void load();

    List<Score> findAll();
}
