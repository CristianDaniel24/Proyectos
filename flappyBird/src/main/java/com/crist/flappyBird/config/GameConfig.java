package com.crist.flappyBird.config;

import com.crist.flappyBird.constants.BirdConstants;
import com.crist.flappyBird.constants.ImagesConstants;
import com.crist.flappyBird.model.Bird;
import javax.swing.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfig {

  // Load images
  @Bean
  public Bird bird() {
    ImagesConstants.BACKGROUND =
        new ImageIcon(getClass().getResource("/images/flappybirdbg.png")).getImage();
    ImagesConstants.TOP_PIPE =
        new ImageIcon(getClass().getResource("/images/toppipe.png")).getImage();
    ImagesConstants.BOTTOM_PIPE =
        new ImageIcon(getClass().getResource("/images/bottompipe.png")).getImage();
    ImagesConstants.BIRD =
        new ImageIcon(getClass().getResource("/images/flappybird.png")).getImage();

    return new Bird(
        BirdConstants.BIRD_X,
        BirdConstants.BIRD_Y,
        BirdConstants.WIDTH,
        BirdConstants.HEIGHT,
        ImagesConstants.BIRD);
  }
}
