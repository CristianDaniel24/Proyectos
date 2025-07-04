package com.crist.chat.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.crist.chat.model.MessageModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface MessageController {

  @GetMapping(produces = APPLICATION_JSON_VALUE)
  ResponseEntity<Iterable<MessageModel>> list();

  @PostMapping(produces = APPLICATION_JSON_VALUE)
  ResponseEntity<MessageModel> create(@RequestBody MessageModel message);

  @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
  ResponseEntity<MessageModel> read(@PathVariable Long id);

  @DeleteMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
  ResponseEntity<MessageModel> delete(@PathVariable Long id);
}
