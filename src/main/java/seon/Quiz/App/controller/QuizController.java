package seon.Quiz.App.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import seon.Quiz.App.model.Question;
import seon.Quiz.App.service.QuizService;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    //because we sedning post request to get quiz list
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String difficultylevel , @RequestParam int numQ){
        return quizService.createQuiz(difficultylevel , numQ);
    }
    @GetMapping("get/{id}")
    public ResponseEntity<List<Question>> getQuizQuestions(@PathVariable Integer id){
        return quizService.getQuizQuestions(id);
    }
}