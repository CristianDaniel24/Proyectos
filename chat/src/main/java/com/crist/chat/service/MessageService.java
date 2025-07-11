package com.crist.chat.service;

import com.crist.chat.model.MessageModel;

public interface MessageService {

  Iterable<MessageModel> list();

  MessageModel create(MessageModel message);
}
