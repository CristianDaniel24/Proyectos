package com.crist.chat.service.impl;

import com.crist.chat.model.RoomModel;
import com.crist.chat.repository.RoomRepository;
import com.crist.chat.service.RoomService;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {

  private final RoomRepository repository;

  public RoomServiceImpl(RoomRepository repository) {
    this.repository = repository;
  }

  @Override
  public Iterable<RoomModel> list() {
    return this.repository.findAll();
  }

  @Override
  public RoomModel create(RoomModel room) {
    return this.repository.save(room);
  }
}
