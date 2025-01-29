package com.thortful.dataaccess.feign.jokes;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "jokesClient", url = "${jokes-client.api.url}")
public interface JokesClient {

  @GetMapping(value = "/random_joke")
  ResponseEntity<Joke> getRandomJoke();
}
