package com.crist.chat.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.crist.chat.model.RoomModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface RoomController {

  @GetMapping(produces = APPLICATION_JSON_VALUE)
  ResponseEntity<Iterable<RoomModel>> list();

  @PostMapping(produces = APPLICATION_JSON_VALUE)
  ResponseEntity<RoomModel> create(@RequestBody RoomModel room);

  @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
  ResponseEntity<RoomModel> read(@PathVariable Long id);

  @DeleteMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
  ResponseEntity<RoomModel> delete(@PathVariable Long id);
}
