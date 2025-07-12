package com.crist.flappyBird.model;

import com.crist.flappyBird.constants.PipesConstants;
import java.awt.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pipe {
  private int x;
  private int y;
  private int width;
  private int height;
  private Boolean passed;
  private Image img;

  public Pipe(Image img) {
    this.img = img;
    this.x = PipesConstants.PIPE_X;
    this.width = PipesConstants.WIDTH;
    this.height = PipesConstants.HEIGHT;
    this.passed = false;
  }
}
