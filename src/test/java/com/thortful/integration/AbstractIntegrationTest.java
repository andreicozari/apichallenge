package com.thortful.integration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.thortful.ThortfulApplication;
import com.thortful.service.JokeService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith({WireMockExtension.class, SpringExtension.class})
@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    classes = ThortfulApplication.class
)
@AutoConfigureMockMvc
@ContextConfiguration(initializers = {WireMockInitializer.class})
public abstract class AbstractIntegrationTest {

  public static WireMockServer jokeClient;
  protected ObjectMapper objectMapper = createObjectMapper();
  @Autowired
  protected JokeService jokeService;
  @Autowired
  protected MockMvc mockMvc;

  @BeforeAll
  public static void beforeAll(@WireMockInstance WireMockServer server) {
    if (jokeClient == null) {
      jokeClient = server;
    }
  }

  @BeforeEach
  void beforeEach() {
    jokeClient.resetAll();
  }

  private ObjectMapper createObjectMapper() {
    final ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL);
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    objectMapper.registerModule(new JavaTimeModule());
    objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    return objectMapper;
  }

}
