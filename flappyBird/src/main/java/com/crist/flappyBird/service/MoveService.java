package com.crist.flappyBird.service;

import com.crist.flappyBird.model.Bird;
import com.crist.flappyBird.model.Pipe;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public interface MoveService extends ActionListener {

  void move();

  void keyTyped(KeyEvent e);

  void keyPressed(KeyEvent e);

  void keyReleased(KeyEvent e);

  boolean collision(Bird a, Pipe b);

  void setPanel(FlappyBirdService panel);
}
