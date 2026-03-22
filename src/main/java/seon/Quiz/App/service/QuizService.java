package seon.Quiz.App.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import seon.Quiz.App.dao.QuestionDao;
import seon.Quiz.App.dao.QuizDao;
import seon.Quiz.App.model.Question;
import seon.Quiz.App.model.Quiz;

import java.util.List;

@Service
public class QuizService {
    
    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;


    public ResponseEntity<String> createQuiz(String difficultylevel, int numQ) {
        List<Question> questions = questionDao.findRandomQuestionsByDifficultyLevel(difficultylevel ,numQ);
        Quiz quiz = new Quiz();
        quiz.setDifficultylevel(difficultylevel);
        quiz.setQuestions(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<Question>> getQuizQuestions(Integer id) {
//        Quiz quiz = quizDao.findById(id);
        return null;
    }
}
