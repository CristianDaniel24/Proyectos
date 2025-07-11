package com.crist.chat.service.impl;

import com.crist.chat.model.MessageModel;
import com.crist.chat.repository.MessageRepository;
import com.crist.chat.service.MessageService;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

  private final MessageRepository repository;

  public MessageServiceImpl(MessageRepository repository) {
    this.repository = repository;
  }

  @Override
  public Iterable<MessageModel> list() {
    return this.repository.findAll();
  }

  @Override
  public MessageModel create(MessageModel message) {
    message.setId(null);
    return this.repository.save(message);
  }
}
