package seon.Quiz.App.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import seon.Quiz.App.Question;
import seon.Quiz.App.dao.QuestionDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQuestions (){
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<List<Question>> getQuestionsByDifficultylevel (String difficultylevel){
        try {
            return new ResponseEntity<>(questionDao.findByDifficultylevel(difficultylevel), HttpStatus.OK);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Question question){
        try {
            questionDao.save(question);
            return new ResponseEntity<>("success", HttpStatus.CREATED);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> deleteQuestionById(Integer id){
        try {
            questionDao.deleteById(id);
            return new ResponseEntity<>("success", HttpStatus.OK);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
    }

    public String updateQuestion(Question question){
        Optional<Question> existing = questionDao.findById(question.getId());
        if(existing.isPresent()){
            questionDao.save(question);
            return "Question updated";
        }

        return "Question not found";
    }


}
