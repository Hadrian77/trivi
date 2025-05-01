package com.trivi.service.repository;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;

import com.trivi.model.questions.Question;
import com.trivi.repository.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;





@SpringBootTest
public class QuestionRepositoryTest {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AmazonDynamoDB amazonDynamoDB;


    @Test
     void testCreateQuestion() {

        Question question = new Question();
        question.setPrompt("Is this a good test?");
        question.setTags(List.of("test"));


       String questionId = questionRepository.save(question).getId();
       Question persistedQuestion = questionRepository.findById(questionId).orElse(null);
       Assertions.assertNotNull(persistedQuestion);
       questionRepository.delete(persistedQuestion);


    }






}
