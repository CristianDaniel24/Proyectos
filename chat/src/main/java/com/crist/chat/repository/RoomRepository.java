package com.crist.chat.repository;

import com.crist.chat.model.RoomModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<RoomModel, Long> {}
