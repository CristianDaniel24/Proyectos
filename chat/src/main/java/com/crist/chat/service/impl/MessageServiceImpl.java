package com.crist.chat.service.impl;

import com.crist.chat.exception.ResourceNotFoundException;
import com.crist.chat.model.MessageModel;
import com.crist.chat.repository.MessageRepository;
import com.crist.chat.service.MessageService;
import org.springframework.dao.DataIntegrityViolationException;
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

  @Override
  public MessageModel read(Long id) {
    return this.repository.findById(id).orElseThrow(ResourceNotFoundException::new);
  }

  @Override
  public MessageModel delete(Long id) {
    try {
      MessageModel message =
          this.repository.findById(id).orElseThrow(ResourceNotFoundException::new);
      this.repository.delete(message);
      return message;
    } catch (DataIntegrityViolationException e) {
      throw new ResourceNotFoundException();
    }
  }
}
