package seon.Quiz.App.service;
import org.springframework.stereotype.Service;

import seon.Quiz.App.dao.QuizDao;

public class QuizService {
    
    @Autowired
    QuizDao quizDao;
}
