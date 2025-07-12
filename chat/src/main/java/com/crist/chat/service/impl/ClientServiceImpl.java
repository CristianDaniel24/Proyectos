package com.crist.chat.service.impl;

import com.crist.chat.model.ClientModel;
import com.crist.chat.repository.ClientRepository;
import com.crist.chat.service.ClientService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

  private final ClientRepository repository;

  public ClientServiceImpl(ClientRepository repository) {
    this.repository = repository;
  }

  @Override
  @Transactional
  public ClientModel create(ClientModel client) {
    return this.repository.save(client);
  }
}
