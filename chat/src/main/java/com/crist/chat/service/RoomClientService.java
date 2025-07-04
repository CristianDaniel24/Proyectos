package com.crist.chat.service;

import com.crist.chat.model.RoomClientModel;

public interface RoomClientService {

  Iterable<RoomClientModel> list();

  RoomClientModel create(RoomClientModel roomClient);

  RoomClientModel read(Long id);

  RoomClientModel delete(Long id);
}
