package com.trivi.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@DynamoDBDocument
public class GameAnswers {

    @DynamoDBAttribute
    private Map<String, Map<String, PlayerAnswer>> questionToPlayerToAnswer;


    public void addAnswer(PlayerAnswer playerAnswer) {

        if (questionToPlayerToAnswer == null) {
            questionToPlayerToAnswer = new HashMap<>();
        }

        if (questionToPlayerToAnswer.containsKey(playerAnswer.getQuestionId())) {
            questionToPlayerToAnswer.get(playerAnswer.getQuestionId()).put(playerAnswer.getPlayerId(), playerAnswer);

        } else {
            HashMap<String, PlayerAnswer> playerIdToPlayerAnswer = new HashMap<>();
            playerIdToPlayerAnswer.put(playerAnswer.getPlayerId(), playerAnswer);
            questionToPlayerToAnswer.put(playerAnswer.getQuestionId(), playerIdToPlayerAnswer);
        }

    }

}
