package com.crist.chat.model;

import jakarta.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "room")
public class RoomModel implements Serializable {

  @Serial private static final long serialVersionUID = 7773631270109353255L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", columnDefinition = "VARCHAR(150)", nullable = false)
  private String name;

  @Column(name = "created_at", columnDefinition = "TIMESTAMP", nullable = false, updatable = false)
  private Timestamp created_at;
}
