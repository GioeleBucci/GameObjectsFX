import javafx.geometry.Point2D;
import javafx.scene.Node;
import lombok.Getter;
import lombok.Setter;

public class GameObject {

  @Getter
  private Node sprite;

  @Getter
  @Setter
  private Point2D direction = new Point2D(0, 0);

  @Getter
  @Setter
  private double velocity;

  //TODO MAKE CONSTRUCTOR WITH ONLY STARTING POSITION
  public GameObject(Node sprite, double velocity) {
    this.velocity = velocity;
    this.sprite = sprite;
  }

  void update() {
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