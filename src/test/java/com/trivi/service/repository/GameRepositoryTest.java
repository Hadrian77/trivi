package com.trivi.service.repository;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.trivi.model.*;
import com.trivi.model.questions.Question;
import com.trivi.repository.GameRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.util.List;

@SpringBootTest
public class GameRepositoryTest {


    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private AmazonDynamoDB amazonDynamoDB;


    @Test
    void testGame(){

        Player player = new Player();
        player.setEmail("person@domain.com");
        player.setFirstName("Player");
        player.setLastName("P");
        player.setTags(List.of("typical","family-friendly"));

        Player player2 = new Player();
        player.setEmail("person2@domain.com");
        player.setFirstName("Player2");
        player.setLastName("P");
        player.setTags(List.of("typical","family-friendly"));

        Game game = new Game();
        game.setStartTime(Instant.now().getEpochSecond());
        game.setEndTime(game.getStartTime() + 1000);
        game.setPlayers(List.of(player,player2));



        GameAnswers gameAnswers  = new GameAnswers();
        PlayerAnswer playerAnswer = new PlayerAnswer("testId","testPlayers","Sure");
        gameAnswers.addAnswer(playerAnswer);

        game.setGameAnswers(new GameAnswers());

        Question question = new Question();
        question.setPrompt("Is this a good test?");
        question.setTags(List.of("test"));

        game.setQuestionBank(List.of(question));

        String gameId = gameRepository.save(game).getId();
        Game persistedGame = gameRepository.findById(gameId).orElse(null);
        Assertions.assertNotNull(persistedGame);





    }

}
