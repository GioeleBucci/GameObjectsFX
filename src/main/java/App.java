import java.util.ArrayList;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class App extends Application {

  public static final int FPS = 30; // TODO watch video about mario movment and learn subpixels

  public static final Group root = new Group();

  public List<GameObject> gameObjects = new ArrayList<>();

  private Player player;

  private long last = 0;

  @Override
  public void start(Stage stage) {

    Scene scene = new Scene(root, 640, 480);

    player = new Player(3);
    player.setVelocity(new Point2D(1, 0));
    addGameObj(player, 300, 300);

    // create second gameObj

    GameObject gameObj2 = new GameObject(new Rectangle(50, 50, Color.RED));
    addGameObj(gameObj2, 450, 300);

    stage.setScene(scene);
    stage.show();

    // start game loop -> update according to FPS
    AnimationTimer timer = new AnimationTimer() {

      float updateRate = 1 / (float) FPS * 1000;

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
    for (GameObject current : gameObjects) {
      if(current.isColliding(player)){
        //System.out.println("collision between " + current + " and " + player);
        player.takeDamage(1);
      }
      current.update();
    }
  }

  public void addGameObj(GameObject object, double x, double y) {
    object.getSprite().setTranslateX(x);
    object.getSprite().setTranslateY(y);
    App.root.getChildren().add(object.getSprite());
    gameObjects.add(object);
  }

  public static void main(String[] args) {
    launch();
  }
}