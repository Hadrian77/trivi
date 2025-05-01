package com.trivi.service;

import com.trivi.model.questions.Question;
import com.trivi.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    public Optional<Question> getQuestionById(String id){
        return questionRepository.findById(id);
    }

    public Question createQuestion(Question question) {

        return questionRepository.save(question);
    }


}
