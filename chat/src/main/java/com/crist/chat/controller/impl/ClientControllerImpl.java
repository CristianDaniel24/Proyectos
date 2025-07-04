package com.crist.chat.controller.impl;

import com.crist.chat.controller.ClientController;
import com.crist.chat.model.ClientModel;
import com.crist.chat.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientControllerImpl implements ClientController {

  private ClientService service;

  @Override
  public ResponseEntity<Iterable<ClientModel>> list() {
    return ResponseEntity.status(HttpStatus.OK).body(this.service.list());
  }

  @Override
  public ResponseEntity<ClientModel> create(ClientModel client) {
    return ResponseEntity.status(HttpStatus.CREATED).body(this.service.create(client));
  }

  @Override
  public ResponseEntity<ClientModel> read(Long id) {
    return ResponseEntity.status(HttpStatus.OK).body(this.service.read(id));
  }

  @Override
  public ResponseEntity<ClientModel> delete(Long id) {
    return ResponseEntity.status(HttpStatus.OK).body(this.service.delete(id));
  }
}
