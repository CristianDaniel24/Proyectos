package com.crist.chat.controller.impl;

import com.crist.chat.controller.MessageController;
import com.crist.chat.model.MessageModel;
import com.crist.chat.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageControllerImpl implements MessageController {

  private final MessageService service;

  public MessageControllerImpl(MessageService service) {
    this.service = service;
  }

  @Override
  public ResponseEntity<Iterable<MessageModel>> list() {
    return ResponseEntity.status(HttpStatus.OK).body(this.service.list());
  }

  @Override
  public ResponseEntity<MessageModel> create(MessageModel message) {
    return ResponseEntity.status(HttpStatus.CREATED).body(this.service.create(message));
  }

  @Override
  public ResponseEntity<MessageModel> read(Long id) {
    return ResponseEntity.status(HttpStatus.OK).body(this.service.read(id));
  }

  @Override
  public ResponseEntity<MessageModel> delete(Long id) {
    return ResponseEntity.status(HttpStatus.OK).body(this.service.delete(id));
  }
}
