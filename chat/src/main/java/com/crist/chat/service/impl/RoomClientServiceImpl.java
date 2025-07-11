package com.crist.chat.service.impl;

import com.crist.chat.model.RoomClientModel;
import com.crist.chat.repository.RoomClientRepository;
import com.crist.chat.service.RoomClientService;
import org.springframework.stereotype.Service;

@Service
public class RoomClientServiceImpl implements RoomClientService {

  private final RoomClientRepository repository;

  public RoomClientServiceImpl(RoomClientRepository repository) {
    this.repository = repository;
  }

  @Override
  public Iterable<RoomClientModel> list() {
    return this.repository.findAll();
  }

  @Override
  public RoomClientModel create(RoomClientModel roomClient) {
    roomClient.setRoom(null);
    roomClient.setClient(null);
    return this.repository.save(roomClient);
  }
}
