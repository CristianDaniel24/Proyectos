package com.crist.chat.controller.impl;

import com.crist.chat.controller.RoomClientController;
import com.crist.chat.model.RoomClientModel;
import com.crist.chat.service.RoomClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roomClient")
public class RoomClientControllerImpl implements RoomClientController {

  private final RoomClientService service;

  public RoomClientControllerImpl(RoomClientService service) {
    this.service = service;
  }

  @Override
  public ResponseEntity<Iterable<RoomClientModel>> list() {
    return ResponseEntity.status(HttpStatus.OK).body(this.service.list());
  }

  @Override
  public ResponseEntity<RoomClientModel> create(RoomClientModel roomClient) {
    return ResponseEntity.status(HttpStatus.CREATED).body(this.service.create(roomClient));
  }

  @Override
  public ResponseEntity<RoomClientModel> read(Long id) {
    return ResponseEntity.status(HttpStatus.OK).body(this.service.read(id));
  }

  @Override
  public ResponseEntity<RoomClientModel> delete(Long id) {
    return ResponseEntity.status(HttpStatus.OK).body(this.service.delete(id));
  }
}
