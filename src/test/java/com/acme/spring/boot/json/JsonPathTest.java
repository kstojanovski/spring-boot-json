package com.acme.spring.boot.json;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

@JsonTest
public class JsonPathTest {

   @Value("classpath:json/example.json")
   Resource exampleJson;

   DocumentContext documentContext;

   @BeforeEach
   void setUp() throws IOException {
      documentContext = Objects.isNull(documentContext)
         ? JsonPath.parse(new String(Files.readAllBytes(exampleJson.getFile().toPath())))
         : documentContext;
   }

   @Test
   void testItemSize() {
      List<Map<String, Object>> items = documentContext.read("$.top.items[*]");
      assertEquals(3, items.size());
   }

   @Test
   void testFirstItem() {
      Map<String, Object> firstItem = documentContext.read("$.top.items[0]");
      assertEquals("John", firstItem.get("name"));
      assertEquals("2024-01-01", firstItem.get("date"));
   }

}
