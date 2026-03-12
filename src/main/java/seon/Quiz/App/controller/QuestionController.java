package seon.Quiz.App.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import seon.Quiz.App.Question;
import seon.Quiz.App.service.QuestionService;

import java.util.List;

//this is controller
@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public List<Question> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("difficultylevel/{difficultylevel}")
    public List<Question> getQuestionsByDifficultylevel(@PathVariable String difficultylevel){
        return questionService.getQuestionsByDifficultylevel(difficultylevel);
    }

    @PostMapping("add")
    public String addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    @DeleteMapping("delete/{id}")
    public String deleteQuestion(@PathVariable Integer id){
        return questionService.deleteQuestionById(id);
    }

    @PutMapping("put")
    public String updateQuestion(@RequestBody Question question){
        return questionService.updateQuestion(question);
    }

}
