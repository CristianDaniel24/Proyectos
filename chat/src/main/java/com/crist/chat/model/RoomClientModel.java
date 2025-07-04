package com.crist.chat.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "room_client")
@IdClass(RoomClientPK.class)
public class RoomClientModel implements Serializable {

  @Serial private static final long serialVersionUID = -8797566492979865426L;

  @Id
  @ManyToOne
  @JsonBackReference
  @JoinColumn(name = "room_id", columnDefinition = "BIGINT", nullable = false)
  private RoomModel room;

  @Id
  @ManyToOne
  @JoinColumn(name = "client_id", columnDefinition = "BIGINT", nullable = false)
  private ClientModel client;
}
