package com.crist.webSocketsEco.service;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class MyWebSocketHandler extends TextWebSocketHandler {
  @Override
  public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
    String received = message.getPayload();
    System.out.println("Mensaje recibido: " + received);

    String response = "Eco del servidor: " + received;
    session.sendMessage(new TextMessage(response));
  }
}
