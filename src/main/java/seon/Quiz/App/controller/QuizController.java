package seon.Quiz.App.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import seon.Quiz.App.service.QuizService;

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
}