package com.crist.chat.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.crist.chat.model.RoomClientModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface RoomClientController {

  @GetMapping(produces = APPLICATION_JSON_VALUE)
  ResponseEntity<Iterable<RoomClientModel>> list();

  @PostMapping(produces = APPLICATION_JSON_VALUE)
  ResponseEntity<RoomClientModel> create(@RequestBody RoomClientModel roomClient);

  @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
  ResponseEntity<RoomClientModel> read(@PathVariable Long id);

  @DeleteMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
  ResponseEntity<RoomClientModel> delete(@PathVariable Long id);
}
