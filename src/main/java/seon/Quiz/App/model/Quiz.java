package seon.Quiz.App.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //quiz with multiple questions
    @ManyToMany
    private List<Question> questions;

    public void setDifficultylevel(String difficultylevel) {

    }

    public void setQuestions(List<Question> questions) {
    }
}
