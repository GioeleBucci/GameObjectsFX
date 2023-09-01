import java.io.Console;

import javafx.animation.AnimationTimer;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.transform.Rotate;

public class PlayerController {

  private Player player;

  public PlayerController(Player player) {

    this.player = player;

    init();

  }

  private void init() {
    App.scene.setOnKeyPressed(event -> {
      KeyCode key = event.getCode();
      if (key == KeyCode.W)
        player.setDirection(new Point2D(0, -1));
      if (key == KeyCode.A)
        player.setDirection(new Point2D(-1, 0));
      if (key == KeyCode.S)
        player.setDirection(new Point2D(0, 1));
      if (key == KeyCode.D)
        player.setDirection(new Point2D(1, 0));
    });

    App.scene.setOnKeyReleased(event -> {
      KeyCode key = event.getCode();
      /* 
      if (key == KeyCode.W)
        isUp = false;
      if (key == KeyCode.A)
        isLeft = false;
      if (key == KeyCode.S)
        isDown = false;
      if (key == KeyCode.D)
        isRight = false;
        */
    });
  }

}
