import javafx.scene.Node;
import lombok.Getter;
import lombok.Setter;

public class Player extends GameObject implements IDamagable {

  @Getter
  @Setter
  private int maxHealth;

  @Getter
  @Setter
  private int currentHealth;

  private PlayerController controller = new PlayerController(this);

  private int iFramesLeft = 0;

  private boolean isDead = false;

  Player(double x, double y, Node sprite, int maxHealth, float speed) {
    super(x, y, sprite);
    this.setSpeed(speed);
    this.maxHealth = maxHealth;
    this.currentHealth = maxHealth;
  }

  public void takeDamage(int amount) {

    if (isDead)
      return;

    // check if there are iFrames
    if (iFramesLeft > 0) {
      iFramesLeft--;
      return;
    }

    // if not take damage and reset IFrames
    this.currentHealth -= amount;
    System.out.println("took " + amount + " damage");

    // update ui
    App.UI.healthBar.update(currentHealth);

    if (currentHealth <= 0)
      die();
    iFramesLeft = MAX_IFRAMES;
  }

  public void die() {

    if (isDead)
      return;

    isDead = true;
    System.out.println("you die!");

    // set speed to 0 so player cant move anymore
    this.setSpeed(0);
  }
}