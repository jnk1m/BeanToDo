package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.config.RepositoryConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {RepositoryConfig.class})
class ScoresTest {

   @Autowired
   Scores scores;

   @Test
   void load() throws NoSuchFieldException, IllegalAccessException {
      scores.load();
      Field field = CsvScores.class.getDeclaredField("scoreList");
      field.setAccessible(true);
      List<Score> scoreList = (List<Score>) field.get(scores);
      Assertions.assertThat(scoreList).isNotEmpty();
   }


   @Test
   void findAll() throws NoSuchFieldException, IllegalAccessException {

      List<Score> scoreList = new ArrayList<>();
      for (int i = 0; i < 10; i++) {
         Score tempScore = new Score(i, 10 * i);
         scoreList.add(tempScore);
      }

//      Scores scores = CsvScores.getInstance();
      Field field = CsvScores.class.getDeclaredField("scoreList");

      field.set(scores, scoreList); //앞에 있는게 타겟이고 뒤에 있는게 들어갈 값

      List<Score> all = scores.findAll();
      Assertions.assertThat(all).isEqualTo(scoreList); //값이 반환되는지 확실히 알 수 있음


   }
}