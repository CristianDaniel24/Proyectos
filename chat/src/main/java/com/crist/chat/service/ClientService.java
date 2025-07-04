package com.crist.chat.service;

import com.crist.chat.model.ClientModel;

public interface ClientService {

  Iterable<ClientModel> list();

  ClientModel create(ClientModel client);

  ClientModel read(Long id);

  ClientModel delete(Long id);
}
