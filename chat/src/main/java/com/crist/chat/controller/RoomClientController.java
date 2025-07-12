package com.crist.chat.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.crist.chat.model.RoomClientModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface RoomClientController {

  @PostMapping(produces = APPLICATION_JSON_VALUE)
  ResponseEntity<RoomClientModel> create(@RequestBody RoomClientModel roomClient);
}
