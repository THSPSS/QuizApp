package seon.Quiz.App.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import seon.Quiz.App.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String difficultylevel , @RequestParam int numQ , @RequestParam String title){
        return new ResponseEntity<>("I'm here", HttpStatus.OK);
    }
}