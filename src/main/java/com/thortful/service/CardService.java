package com.thortful.service;

import com.thortful.dataaccess.Card;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CardService {

  Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CardService.class);

  public List<Card> getDefaultListOfCards() {
    var theCard = Card.builder()
        .id("1")
        .name("Your lovely card")
        .description("The greeting card description.")
        .build();

    LOGGER.info("Retrieving the default list of greeting cards.");

    return List.of(theCard);
  }
}
