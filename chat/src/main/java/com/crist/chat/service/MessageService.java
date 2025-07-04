package com.crist.chat.service;

import com.crist.chat.model.MessageModel;

public interface MessageService {

  Iterable<MessageModel> list();

  MessageModel create(MessageModel message);

  MessageModel read(Long id);

  MessageModel delete(Long id);
}
