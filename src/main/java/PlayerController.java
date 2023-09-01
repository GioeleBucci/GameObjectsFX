import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;

public class PlayerController {

  public static Point2D DIRECTION_UP = new Point2D(0, -1);
  public static Point2D DIRECTION_DOWN = new Point2D(0, 1);
  public static Point2D DIRECTION_LEFT = new Point2D(-1, 0);
  public static Point2D DIRECTION_RIGHT = new Point2D(1, 0);

  private Player player;

  public PlayerController(Player player) {

    this.player = player;

    init();

  }

  /** Initializes key events for movement */
  private void init() {
    App.scene.setOnKeyPressed(event -> {
      KeyCode key = event.getCode();
      if (key == KeyCode.W)
        player.setDirection(DIRECTION_UP);
      if (key == KeyCode.A)
        player.setDirection(DIRECTION_LEFT);
      if (key == KeyCode.S)
        player.setDirection(DIRECTION_DOWN);
      if (key == KeyCode.D)
        player.setDirection(DIRECTION_RIGHT);
    });

    App.scene.setOnKeyReleased(event -> {
      KeyCode key = event.getCode();
      if (key == KeyCode.W || key == KeyCode.A || key == KeyCode.S || key == KeyCode.D) {
        player.setDirection(new Point2D(0, 0));
      }
    });
  }

}
