package com.thortful.infrastructure.rest;

import com.thortful.dataaccess.feign.jokes.Joke;
import com.thortful.service.JokeService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class JokesController {

  private final JokeService jokeService;

  @Operation(
      summary = "Get a random joke",
      description = "Get a random joke."
  )
  @GetMapping("/random-joke")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<Joke> getRandomJoke() {
    return ResponseEntity.ok(
        jokeService.getRandomJoke());
  }

}
