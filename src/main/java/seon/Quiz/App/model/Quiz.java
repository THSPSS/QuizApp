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
    private String title;

    //mapping one quiz with multiple questions
    @ManyToMany
    private List<Question> questions;
}
