package com.crist.chat.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.crist.chat.model.ClientModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface ClientController {

  @PostMapping(produces = APPLICATION_JSON_VALUE)
  ResponseEntity<ClientModel> create(@RequestBody ClientModel client);
}
