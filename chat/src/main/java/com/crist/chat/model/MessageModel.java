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
@Table(name = "message")
public class MessageModel implements Serializable {

  @Serial private static final long serialVersionUID = -4196583947046076426L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "text", columnDefinition = "VARCHAR(500)", nullable = false)
  private String text;

  @Column(name = "sent_at", columnDefinition = "TIMESTAMP", nullable = false, updatable = false)
  private Timestamp sent_at;
}
