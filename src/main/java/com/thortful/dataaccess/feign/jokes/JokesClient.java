package com.thortful.dataaccess.feign.jokes;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "jokes-api", url = "${jokes-api.url}")
public interface JokesClient {


  Logger LOGGER = org.slf4j.LoggerFactory.getLogger(JokesClient.class);


  @GetMapping(value = "/jokes/random")
  @CircuitBreaker(name = "jokes-api-circuit", fallbackMethod = "getRandomJokeFallback")
  ResponseEntity<Joke> getRandomJoke();

  default ResponseEntity<Joke> getRandomJokeFallback(Throwable t) {
    LOGGER.error("Failed to retrieve random joke from joke-api. ", t);
    return ResponseEntity.noContent().build();
  }
}
