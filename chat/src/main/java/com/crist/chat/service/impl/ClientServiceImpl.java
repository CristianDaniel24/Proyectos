package com.crist.chat.service.impl;

import com.crist.chat.exception.ResourceNotFoundException;
import com.crist.chat.model.ClientModel;
import com.crist.chat.repository.ClientRepository;
import com.crist.chat.service.ClientService;
import jakarta.transaction.Transactional;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

  private final ClientRepository repository;

  public ClientServiceImpl(ClientRepository repository) {
    this.repository = repository;
  }

  @Override
  public Iterable<ClientModel> list() {
    return this.repository.findAll();
  }

  @Override
  @Transactional
  public ClientModel create(ClientModel client) {
    client.setId(null);
    return this.repository.save(client);
  }

  @Override
  public ClientModel read(Long id) {
    return this.repository.findById(id).orElseThrow(ResourceNotFoundException::new);
  }

  @Override
  public ClientModel delete(Long id) {
    try {
      ClientModel client = this.repository.findById(id).orElseThrow(ResourceNotFoundException::new);
      this.repository.delete(client);
      return client;
    } catch (DataIntegrityViolationException e) {
      throw new ResourceNotFoundException();
    }
  }
}
