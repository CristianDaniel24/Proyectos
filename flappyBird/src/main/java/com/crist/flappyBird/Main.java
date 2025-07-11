package com.crist.flappyBird;

import com.crist.flappyBird.constants.BoardConstants;
import com.crist.flappyBird.service.FlappyBirdService;
import javax.swing.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Main {
  public static void main(String[] args) {
    System.setProperty("java.awt.headless", "false");

    ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);

    FlappyBirdService flappyBird = context.getBean(FlappyBirdService.class);

    JFrame frame = new JFrame("Flappy Bird");
    frame.setSize(BoardConstants.WIDTH, BoardConstants.HEIGHT);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.add(flappyBird);
    frame.pack();
    flappyBird.requestFocus();
    frame.setVisible(true);
  }
}
