package com.thortful.integration;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.thortful.dataaccess.feign.jokes.Joke;
import org.junit.jupiter.api.Test;

public class JokeControllerIntegrationTest extends AbstractIntegrationTest {


  @Test
  void test_shouldReturnJoke() throws Exception {
    var joke = Joke.builder()
        .id("1")
        .setup("setup")
        .punchline("punchline")
        .type("dev")
        .build();

    jokeClient.stubFor(WireMock.get("/random-joke").willReturn(
        WireMock.aResponse().withStatus(200).withHeader("Content-Type", "application/json")
            .withBody(objectMapper.writeValueAsString(joke))));

    mockMvc.perform(get("/v1/joke"))
        .andExpect(status().isOk()).andReturn();
  }

}
