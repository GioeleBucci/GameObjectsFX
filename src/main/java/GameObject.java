import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;
import lombok.Getter;
import lombok.Setter;

public class GameObject {

  @Getter
  @Setter
  private Node sprite = new Rectangle(0, 0);

  @Getter
  @Setter
  private Point2D direction = new Point2D(0, 0);

  @Getter
  @Setter
  private double velocity = 0;

  public GameObject(double x, double y) {
    Point2D position = new Point2D(x, y);
    init(position);
  }

  public GameObject(double x, double y, Node sprite) {
    this.setSprite(sprite);

    Point2D position = new Point2D(x, y);
    init(position);
  }

  private void init(Point2D position) {
    this.getSprite().setTranslateX(position.getX());
    this.getSprite().setTranslateY(position.getY());
    App.root.getChildren().add(this.getSprite());
    App.gameObjects.add(this);
  }

  public void update() {
    this.sprite.setTranslateX(sprite.getTranslateX() + direction.getX() * velocity);
    this.sprite.setTranslateY(sprite.getTranslateY() + direction.getY() * velocity);
  }

  public boolean isColliding(GameObject other) {
    // avoid checking collision on self
    if (other == this)
      return false;
    return getSprite().getBoundsInParent().intersects(other.getSprite().getBoundsInParent());
  }
}