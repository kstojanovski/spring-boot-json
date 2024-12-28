package com.acme.spring.boot.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.core.io.Resource;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@JsonTest
public class JsonJacksonTest {

   @Value("classpath:json/example.json")
   Resource exampleJson;

   @Autowired
   ObjectMapper objectMapper;

   JsonNode jsonNode;

   @BeforeEach
   void setUp() throws IOException {
      jsonNode = objectMapper.readTree(exampleJson.getInputStream());
   }

   @Test
   void contextTest() {
      assertNotNull(objectMapper);
   }

   @Test
   void testItemSize() {
      JsonNode items = jsonNode.path("top").path("items");
      assertEquals(3, items.size());
   }

   @Test
   void testFirstItem() {
      JsonNode firstItem = jsonNode.path("top").path("items").get(0);
      assertEquals("John", firstItem.get("name").asText());
      assertEquals("2024-01-01", firstItem.get("date").asText());
   }

}
