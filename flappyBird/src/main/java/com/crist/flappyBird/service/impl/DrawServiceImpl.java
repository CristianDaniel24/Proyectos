package com.crist.flappyBird.service.impl;

import com.crist.flappyBird.constants.BoardConstants;
import com.crist.flappyBird.constants.GameLogicConstants;
import com.crist.flappyBird.constants.ImagesConstants;
import com.crist.flappyBird.constants.PipesConstants;
import com.crist.flappyBird.model.Bird;
import com.crist.flappyBird.model.Pipe;
import com.crist.flappyBird.service.DrawService;
import java.awt.*;
import org.springframework.stereotype.Service;

@Service
public class DrawServiceImpl implements DrawService {

  private final Bird bird;

  public DrawServiceImpl(Bird bird) {
    this.bird = bird;
  }

  /**
   * Se encarga de dibujar las imagenes como los fondos, el pajaro, tuberias y mensajes
   *
   * @param g Actua como un lienzo que contiene todos los metodos necesarios para dibujar formas,
   *     texto, imgenes, etc
   */
  @Override
  public void draw(Graphics g) {
    // Background
    g.drawImage(
        ImagesConstants.BACKGROUND, 0, 0, BoardConstants.WIDTH, BoardConstants.HEIGHT, null);

    // bird
    g.drawImage(bird.getImg(), bird.getX(), bird.getY(), bird.getWidth(), bird.getHeight(), null);

    // pipes
    for (Pipe pipe : PipesConstants.PIPES_LIST) {
      g.drawImage(pipe.getImg(), pipe.getX(), pipe.getY(), pipe.getWidth(), pipe.getHeight(), null);
    }

    // score
    g.setColor(Color.white);
    g.setFont(new Font("Arial", Font.PLAIN, 32));
    if (GameLogicConstants.GAME_OVER) {
      g.drawString("Game Over: " + String.valueOf((int) GameLogicConstants.SCORE), 10, 35);
    } else {
      g.drawString(String.valueOf((int) GameLogicConstants.SCORE), 10, 35);
    }
  }

  /** Se encarga de generar las tuberias de forma aleatoria */
  @Override
  public void placePipes() {
    // (0-1) * pipeHeight/2 -> (0-256)
    // 128
    // 0 - 128 - (0-256) --> pipeHeight/4 -> 3/4 pipeHeight

    int randomPipeY =
        (int)
            (PipesConstants.PIPE_Y
                - PipesConstants.HEIGHT / 4
                - Math.random() * PipesConstants.HEIGHT / 2);
    int openingSpace = BoardConstants.HEIGHT / 4;

    Pipe topPipe = new Pipe(ImagesConstants.TOP_PIPE);
    topPipe.setY(randomPipeY);
    PipesConstants.PIPES_LIST.add(topPipe);

    Pipe bottomPipe = new Pipe(ImagesConstants.BOTTOM_PIPE);
    bottomPipe.setY(topPipe.getY() + PipesConstants.HEIGHT + openingSpace);
    PipesConstants.PIPES_LIST.add(bottomPipe);
  }
}
