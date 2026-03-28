package seon.Quiz.App.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import seon.Quiz.App.model.Question;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

    List<Question> findByDifficultylevel(String difficultylevel);

    @Query(value = "SELECT * FROM question q WHERE q.difficultylevel=:difficultylevel ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
    List<Question> findRandomQuestionsByDifficultylevel(String difficultylevel, int numQ);
}
