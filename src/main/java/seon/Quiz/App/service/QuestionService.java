package seon.Quiz.App.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seon.Quiz.App.Question;
import seon.Quiz.App.dao.QuestionDao;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public List<Question> getAllQuestions (){
        return questionDao.findAll();
    }

    public List<Question> getQuestionsByDifficultylevel (String difficultylevel){
        return questionDao.findByDifficultylevel(difficultylevel);
    }

    public String addQuestion(Question question){
        questionDao.save(question);
        return "success";
    }

    public String deleteQuestionById(Integer id){
        questionDao.deleteById(id);
        return "success";
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
