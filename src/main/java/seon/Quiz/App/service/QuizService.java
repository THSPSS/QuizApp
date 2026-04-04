package seon.Quiz.App.service;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import seon.Quiz.App.dao.QuestionDao;
import seon.Quiz.App.dao.QuizDao;
import seon.Quiz.App.model.Question;
import seon.Quiz.App.model.QuestionWrapper;
import seon.Quiz.App.model.Quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;


    public ResponseEntity<String> createQuiz(String difficultylevel, int numQ , String title) {
        List<Question> questions = questionDao.findRandomQuestionsByDifficultylevel(difficultylevel ,numQ);

        System.out.println("Questions size: " + questions.size());

        for (Question q : questions) {
            System.out.println(q);
        }

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);

        quizDao.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz = quizDao.findById(id);

        //quiz object has questions
        List<Question> questionsFromDb  = quiz.get().getQuestions();
        List<QuestionWrapper> questionsForUser = new ArrayList<>();
        for(Question q : questionsFromDb) {
            QuestionWrapper qw = new QuestionWrapper(
                    q.getId(),
                    q.getQuestionTitle() ,
                    q.getOption1() ,
                    q.getOption2() ,
                    q.getOption3() ,
                    q.getOption4()
            );
            questionsForUser.add(qw);
        }

        return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Quiz quiz = quizDao.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        int right = 0;
        int i = 0;
        for(Response response : responses) {
            if(response.getResponse().equals(questions.get(i).getCorrectAnswer()))
                right++;
            i++;
        }
        return new ResponseEntity<>(right, HttpStatus.OK);
    }
}
