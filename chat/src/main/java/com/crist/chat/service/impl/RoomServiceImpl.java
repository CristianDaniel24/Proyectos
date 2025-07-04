package com.crist.chat.service.impl;

import com.crist.chat.exception.ResourceNotFoundException;
import com.crist.chat.model.RoomModel;
import com.crist.chat.repository.RoomRepository;
import com.crist.chat.service.RoomService;
import org.springframework.dao.DataIntegrityViolationException;
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
    room.setId(null);
    return this.repository.save(room);
  }

  @Override
  public RoomModel read(Long id) {
    return this.repository.findById(id).orElseThrow(ResourceNotFoundException::new);
  }

  @Override
  public RoomModel delete(Long id) {
    try {
      RoomModel room = this.repository.findById(id).orElseThrow(ResourceNotFoundException::new);
      this.repository.delete(room);
      return room;
    } catch (DataIntegrityViolationException e) {
      throw new ResourceNotFoundException();
    }
  }
}
