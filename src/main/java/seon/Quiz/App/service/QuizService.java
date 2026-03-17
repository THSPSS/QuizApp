package seon.Quiz.App.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import seon.Quiz.App.dao.QuizDao;
import seon.Quiz.App.model.Quiz;

public class QuizService {
    
    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;


    public ResponseEntity<String> createQuiz(String difficultylevel, int numQ) {
        List<Question> question = questionDao.findRandomeQuestionsByDiffcultyLevel(difficultylevel ,numQ);
        Quiz quiz = new Quiz();
        quiz.setDifficultylevel(difficultylevel);
    }
}
