package com.trivi.model.questions;



import java.util.Map;

public class MultipleChoiceQuestion extends Question {

    /**
     * Map ordered from 1 to n of choices available as responses to a question
     */
    Map<Integer,String> choice;
    

}
