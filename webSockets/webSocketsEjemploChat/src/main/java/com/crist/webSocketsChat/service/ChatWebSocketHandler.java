package com.crist.webSocketsChat.service;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class ChatWebSocketHandler extends TextWebSocketHandler {
  private final Set<WebSocketSession> sessions = new CopyOnWriteArraySet<>();

  @Override
  public void afterConnectionEstablished(WebSocketSession session) {
    sessions.add(session);
    System.out.println("Nueva conexión: " + session.getId());
  }

  @Override
  public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
    System.out.println("Mensaje de " + session.getId() + ": " + message.getPayload());
    this.sessions.stream()
        .filter(WebSocketSession::isOpen)
        .forEach(
            s -> {
              try {
                s.sendMessage(
                    new TextMessage("Usuario " + session.getId() + ": " + message.getPayload()));
              } catch (Exception e) {
                e.printStackTrace();
              }
            });
  }

  @Override
  public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
    sessions.remove(session);
    System.out.println("Conexión cerrada: " + session.getId());
  }
}
