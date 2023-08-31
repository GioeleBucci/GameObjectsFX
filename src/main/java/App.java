import java.util.ArrayList;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

  public static final int FPS = 10; //TODO watch video about mario movment and learn subpixels

  public static final Group root = new Group();

  private List<GameObject> gameObjects = new ArrayList<>();

  private GameObject player;

  private long last = 0;

  @Override
  public void start(Stage stage) {

    Scene scene = new Scene(root, 640, 480);

    player = new Player();
    player.setVelocity(new Point2D(1, 0));
    gameObjects.add(player);
    addGameObj(player, 300, 300);

    stage.setScene(scene);
    stage.show();

    // start game loop -> update according to FPS
    AnimationTimer timer = new AnimationTimer() {
      long updateRate = 1 / FPS * 1000;

      @Override
      public void handle(long now) {
        long current = System.currentTimeMillis();

        if (current - last > updateRate) {
          last = current;
          updateAll();
        }
      }
    };

    timer.start();
  }

  private void updateAll() {
    player.update();
    for (GameObject gameObject : gameObjects) {
      gameObject.update();
    }
  }

  public void addGameObj(GameObject object, double x, double y) {
    object.getSprite().setTranslateX(x);
    object.getSprite().setTranslateY(y);
    App.root.getChildren().add(object.getSprite());
  }

  public static void main(String[] args) {
    launch();
  }
}