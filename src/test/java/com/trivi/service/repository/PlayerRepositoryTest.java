package com.trivi.service.repository;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.trivi.model.Player;
import com.trivi.repository.PlayerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PlayerRepositoryTest {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private AmazonDynamoDB amazonDynamoDB;


    @Test
    void testCreatePlayer() {

        Player player = new Player();
        player.setEmail("person@domain.com");
        player.setFirstName("Player");
        player.setLastName("P");
        player.setTags(List.of("typical","family-friendly"));


        String playerId = playerRepository.save(player).getId();
        Player persistedPlayer = playerRepository.findById(playerId).orElse(null);
        Assertions.assertNotNull(persistedPlayer);
        playerRepository.delete(persistedPlayer);


    }



}
