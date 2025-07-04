package com.crist.chat.model;

import java.io.Serial;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomClientPK implements Serializable {

  @Serial private static final long serialVersionUID = -402685778358742730L;

  private RoomModel room;

  private ClientModel client;
}
