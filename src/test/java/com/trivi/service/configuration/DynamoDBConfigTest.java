package com.trivi.service.configuration;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.model.ListTablesRequest;
import com.amazonaws.services.dynamodbv2.model.ListTablesResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class DynamoDBConfigTest {

    @Autowired
    private AmazonDynamoDB amazonDynamoDB;

    @Test
    public void testDynamoDBConnection() {
        assertNotNull(amazonDynamoDB, "DynamoDB client should not be null");

        // Test connection by listing DynamoDB tables
        ListTablesRequest request = new ListTablesRequest();
        ListTablesResult result = amazonDynamoDB.listTables(request);

        // Check that the result is not null and contains tables
        assertNotNull(result);
        System.out.println("Tables in DynamoDB: " + result.getTableNames());
    }
}