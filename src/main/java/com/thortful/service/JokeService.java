package com.thortful.service;

import com.thortful.dataaccess.feign.jokes.Joke;
import com.thortful.dataaccess.feign.jokes.JokesClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class JokeService {

  private final JokesClient jokesClient;
  Logger LOGGER = org.slf4j.LoggerFactory.getLogger(JokeService.class);

  public Joke getRandomJoke() {
    var responseBody = jokesClient.getRandomJoke();

    var joke = responseBody.getBody();

    LOGGER.info(String.format("Retrieved new joke: %s", joke.getSetup()));

    return joke;
  }

}
