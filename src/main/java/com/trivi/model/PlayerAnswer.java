package com.trivi.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.Data;

@Data
@DynamoDBDocument
public class PlayerAnswer {

    private String questionId;
    private String playerId;
    private String choice;

    public PlayerAnswer(String questionId, String playerId, String choice) {
        this.questionId = questionId;
        this.playerId = playerId;
        this.choice = choice;
    }


    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }
}
