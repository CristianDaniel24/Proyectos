package com.crist.chat.model;

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
@Table(name = "client")
public class ClientModel implements Serializable {

  @Serial private static final long serialVersionUID = 1067615269748846685L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", columnDefinition = "VARCHAR(250)", nullable = false)
  private String name;

  @Column(name = "mail", columnDefinition = "VARCHAR(250)", nullable = false, unique = true)
  private String mail;
}
