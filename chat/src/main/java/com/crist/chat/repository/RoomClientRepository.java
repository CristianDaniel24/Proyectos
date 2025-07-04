package com.crist.chat.repository;

import com.crist.chat.model.RoomClientModel;
import com.crist.chat.model.RoomClientPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomClientRepository extends JpaRepository<RoomClientModel, RoomClientPK> {}
