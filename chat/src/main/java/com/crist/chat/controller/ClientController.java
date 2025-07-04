package com.crist.chat.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.crist.chat.model.ClientModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface ClientController {

  @GetMapping(produces = APPLICATION_JSON_VALUE)
  ResponseEntity<Iterable<ClientModel>> list();

  @PostMapping(produces = APPLICATION_JSON_VALUE)
  ResponseEntity<ClientModel> create(@RequestBody ClientModel client);

  @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
  ResponseEntity<ClientModel> read(@PathVariable Long id);

  @DeleteMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
  ResponseEntity<ClientModel> delete(@PathVariable Long id);
}
