import javafx.geometry.Point2D;
import javafx.scene.Node;
import lombok.Getter;
import lombok.Setter;

public class GameObject {
  @Getter
  private Node sprite;
  @Getter @Setter 
  private Point2D velocity = new Point2D(0, 0);

  public GameObject(Node sprite) {
    this.sprite = sprite;
  }

  void update() {
    System.out.println("updating");
    this.sprite.setTranslateX(sprite.getTranslateX() + velocity.getX());
    this.sprite.setTranslateY(sprite.getTranslateY() + velocity.getY());
  }

  public boolean isColliding(GameObject other) {
    return getSprite().getBoundsInParent().intersects(other.getSprite().getBoundsInParent());
  }
}