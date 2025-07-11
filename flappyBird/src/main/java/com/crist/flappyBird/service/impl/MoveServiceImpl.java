package com.crist.flappyBird.service.impl;

import com.crist.flappyBird.constants.BirdConstants;
import com.crist.flappyBird.constants.BoardConstants;
import com.crist.flappyBird.constants.GameLogicConstants;
import com.crist.flappyBird.constants.PipesConstants;
import com.crist.flappyBird.model.Bird;
import com.crist.flappyBird.model.Pipe;
import com.crist.flappyBird.service.FlappyBirdService;
import com.crist.flappyBird.service.MoveService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import lombok.Setter;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class MoveServiceImpl implements ActionListener, KeyListener, MoveService {

  private final Bird bird;
  @Setter private FlappyBirdService panel;

  public MoveServiceImpl(Bird bird, @Lazy FlappyBirdService panel) {
    this.bird = bird;
    this.panel = panel;
  }

  /**
   * Este metodo permite darle movimiento al pajaro como tambien calcular su score y saber en que
   * caso el jugador pierde la partida
   */
  @Override
  public void move() {
    // bird
    GameLogicConstants.VELOCITY_Y += GameLogicConstants.GRAVITY;
    int birdY = bird.getY();
    birdY += GameLogicConstants.VELOCITY_Y;
    bird.setY(birdY);

    int birdY2 = bird.getY();
    birdY2 = Math.max(bird.getY(), 0);
    bird.setY(birdY2);

    // pipes
    for (int i = 0; i < PipesConstants.PIPES_LIST.size(); i++) {
      Pipe pipe = PipesConstants.PIPES_LIST.get(i);
      int pipeX = pipe.getX();
      pipeX += GameLogicConstants.VELOCITY_X;
      pipe.setX(pipeX);

      if (!pipe.getPassed() && bird.getX() > pipe.getX() + pipe.getWidth()) {
        pipe.setPassed(true);
        GameLogicConstants.SCORE +=
            0.5; // 0.5 because there are 2 pipes! so 0.5*2 = 1, 1 for each set of pipes
      }

      if (collision(bird, pipe)) {
        GameLogicConstants.GAME_OVER = true;
      }
    }

    if (bird.getY() > BoardConstants.HEIGHT) {
      GameLogicConstants.GAME_OVER = true;
    }
  }

  /**
   * Contiene la logica de colision en caso de que el pajaro colisione con alguna tuberia
   *
   * @param a Objeto que representa el pajaro con sus dimensiones
   * @param b Objeto que representa las tuberias con sus dimensiones
   */
  @Override
  public boolean collision(Bird a, Pipe b) {
    return a.getX()
            < b.getX() + b.getWidth() // a's top left corner doesn't reach b's top right corner
        && a.getX() + a.getWidth() > b.getX() // a's top right corner passes b's top left corner
        && a.getY()
            < b.getY() + b.getHeight() // a's top left corner doesn't reach b's bottom left corner
        && a.getY() + a.getHeight() > b.getY(); // a's bottom left corner passes b's top left corner
  }

  /**
   * Se encarga de escuchar cuando se presiona una tecla permitiendo dar el movimiento al pajaro,
   * como tambien permitir reiniciar el juego cuando el jugador pierde la partida
   *
   * @param e Es un objeto que representa un evento del teclado y contiene información sobre qué
   *     tecla fue presionada, soltada o tipeada
   */
  @Override
  public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_SPACE) {
      GameLogicConstants.VELOCITY_Y = -9;
      if (GameLogicConstants.GAME_OVER) {
        // Restart the game by resetting the conditions
        bird.setY(BirdConstants.BIRD_Y);
        GameLogicConstants.VELOCITY_Y = 0;
        PipesConstants.PIPES_LIST.clear();
        GameLogicConstants.SCORE = 0;
        GameLogicConstants.GAME_OVER = false;
        GameLogicConstants.GAME_LOOP.start();
        GameLogicConstants.PLACE_PIPES_TIMER.start();
      }
    }
  }

  @Override
  public void keyTyped(KeyEvent e) {}

  @Override
  public void keyReleased(KeyEvent e) {}

  /**
   * Se encarga de permitir la ejecucion del juego como tambien de detener la ejecucion del mismo
   *
   * @param e Es un objeto que representa un evento de accion en Java se recibe cada vez que ocurre
   *     una accion programada
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    move();
    this.panel.repaint();
    if (GameLogicConstants.GAME_OVER) {
      GameLogicConstants.PLACE_PIPES_TIMER.stop();
      GameLogicConstants.GAME_LOOP.stop();
    }
  }
}
