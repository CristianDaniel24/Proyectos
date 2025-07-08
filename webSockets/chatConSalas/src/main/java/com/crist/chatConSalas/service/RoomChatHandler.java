package com.crist.chatConSalas.service;

import com.crist.chatConSalas.model.ChatMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class RoomChatHandler extends TextWebSocketHandler {

  private final ObjectMapper objectMapper = new ObjectMapper();

  private final Map<String, Set<WebSocketSession>> roomSessions = new ConcurrentHashMap<>();

  @Override
  protected void handleTextMessage(WebSocketSession session, TextMessage textMessage)
      throws Exception {
    ChatMessage msg = objectMapper.readValue(textMessage.getPayload(), ChatMessage.class);
    String room = msg.getRoom();
    String message = msg.getMessage();

    roomSessions.putIfAbsent(room, ConcurrentHashMap.newKeySet());
    roomSessions.get(room).add(session);

    String broadcast = "[Sala: " + room + "] Mensaje: " + message;

    roomSessions.get(room).stream()
        .filter(WebSocketSession::isOpen)
        .forEach(
            s -> {
              try {
                s.sendMessage(new TextMessage(broadcast));
              } catch (Exception e) {
                e.printStackTrace();
              }
            });
  }

  @Override
  public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
    roomSessions.values().forEach(s -> s.remove(session));
  }
}
