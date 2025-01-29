package com.thortful.infrastructure.rest;

import com.thortful.dataaccess.Card;
import com.thortful.service.CardService;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
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
public class CardsController {

  private final CardService cardService;

  @Operation(
      summary = "Greeting cards default list.",
      description = "Get a default list of greeting cards."
  )
  @GetMapping("/cards")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<List<Card>> getDefaultListOfCards() {
    return ResponseEntity.ok(
        cardService.getDefaultListOfCards());
  }

}
