import javafx.scene.Node;
import lombok.Getter;
import lombok.Setter;

public class Player extends GameObject implements IDamagable {

  @Getter
  @Setter
  private int maxHealth;

  @Getter
  @Setter
  private int currentHealth = maxHealth;

  private PlayerController controller = new PlayerController(this);

  private int iFramesLeft = 0;

  Player(double x, double y, Node sprite, int maxHealth, float velocity) {
    super(x, y, sprite);
    this.setVelocity(velocity);
    this.maxHealth = maxHealth;
  }

  public void takeDamage(int amount) {

    // check if there are iFrames
    if (iFramesLeft > 0) {
      iFramesLeft--;
      return;
    }

    // if not take damage and reset IFrames
    this.currentHealth -= amount;
    System.out.println("took " + amount + " damage");
    iFramesLeft = MAX_IFRAMES;
  }
}