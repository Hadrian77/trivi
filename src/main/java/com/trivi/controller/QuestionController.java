package com.trivi.controller;

import com.trivi.model.Question;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/questions")
public class QuestionController {

    @GetMapping("/{id}")
    public Question getQuestionById(@PathVariable String id){

        return null;
    }

    @PostMapping
    public Question createQuestion(@RequestBody Question question) {

        return null;
    }


}
