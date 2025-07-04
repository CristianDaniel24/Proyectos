package com.crist.chat.service;

import com.crist.chat.model.RoomModel;

public interface RoomService {

  Iterable<RoomModel> list();

  RoomModel create(RoomModel room);

  RoomModel read(Long id);

  RoomModel delete(Long id);
}
