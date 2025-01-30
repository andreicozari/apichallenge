package com.thortful.infrastructure.rest.exception;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.message.SimpleMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;

@Slf4j
@RestControllerAdvice
public class GeneralExceptionHandler {

  @ExceptionHandler(value = {FeignException.class})
  public ResponseEntity<SimpleMessage> handleFeignException(final FeignException ex,
      final ServletWebRequest request) {
    return ResponseEntity.status(ex.status()).body(
        new SimpleMessage(ex.getMessage()));
  }
}
