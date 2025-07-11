package com.crist.flappyBird.model;

import com.crist.flappyBird.constants.BirdConstants;
import java.awt.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bird {
  private int x;
  private int y;
  private int width;
  private int height;
  private Image img;

  public Bird(Image img) {
    this.x = BirdConstants.BIRD_X;
    this.y = BirdConstants.BIRD_Y;
    this.width = BirdConstants.WIDTH;
    this.height = BirdConstants.HEIGHT;
    this.img = img;
  }
}
