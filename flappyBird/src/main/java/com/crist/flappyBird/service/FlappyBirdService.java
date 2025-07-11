package com.crist.flappyBird.service;

import com.crist.flappyBird.constants.BoardConstants;
import com.crist.flappyBird.constants.GameLogicConstants;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.springframework.stereotype.Service;

@Service
public class FlappyBirdService extends JPanel implements KeyListener {

  private final DrawService draw;
  private final MoveService move;

  /**
   * Este constructor actua como un facade que permite definir las dimensiones como tambien
   * inicializar la apliacion junto a los Timers del juego
   *
   * @param move Es la interfaz que contiene la logica de movimiento del juego y de su
   *     funcionamiento
   * @param draw Es la interfaz que contiene los metodos que permiten darle un diseño del juego
   */
  public FlappyBirdService(MoveService move, DrawService draw) {
    this.move = move;
    this.draw = draw;

    setPreferredSize(new Dimension(BoardConstants.WIDTH, BoardConstants.HEIGHT));
    setFocusable(true);
    move.setPanel(this);
    addKeyListener(this);

    // place pipes timer
    GameLogicConstants.PLACE_PIPES_TIMER =
        new Timer(
            1500,
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                draw.placePipes();
              }
            });
    GameLogicConstants.PLACE_PIPES_TIMER.start();

    // game timer
    GameLogicConstants.GAME_LOOP = new Timer(1000 / 60, move); // 1000/60 = 16.6
    GameLogicConstants.GAME_LOOP.start();
  }

  /**
   * Permite pintar el contenido del juego
   *
   * @param g Es un objeto que da acceso a las herramientas de dibujo
   */
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    draw.draw(g); // Esto hace que se dibuje el juego
  }

  @Override
  public void keyTyped(KeyEvent e) {
    move.keyTyped(e);
  }

  @Override
  public void keyPressed(KeyEvent e) {
    move.keyPressed(e);
  }

  @Override
  public void keyReleased(KeyEvent e) {
    move.keyReleased(e);
  }
}
