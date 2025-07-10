package com.crist.chat.controller.impl;

import com.crist.chat.controller.RoomController;
import com.crist.chat.model.RoomModel;
import com.crist.chat.service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/room")
public class RoomControllerImpl implements RoomController {

  private final RoomService service;

  public RoomControllerImpl(RoomService service) {
    this.service = service;
  }

  @Override
  public ResponseEntity<Iterable<RoomModel>> list() {
    return ResponseEntity.status(HttpStatus.OK).body(this.service.list());
  }

  @Override
  public ResponseEntity<RoomModel> create(RoomModel room) {
    return ResponseEntity.status(HttpStatus.CREATED).body(this.service.create(room));
  }

  @Override
  public ResponseEntity<RoomModel> read(Long id) {
    return ResponseEntity.status(HttpStatus.OK).body(this.service.read(id));
  }

  @Override
  public ResponseEntity<RoomModel> delete(Long id) {
    return ResponseEntity.status(HttpStatus.OK).body(this.service.delete(id));
  }
}
