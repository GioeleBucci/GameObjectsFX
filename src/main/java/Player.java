import core.Tags;
import javafx.scene.Node;
import lombok.Getter;
import lombok.Setter;

public class Player extends GameObject implements IDamagable {

  @Getter
  @Setter
  private int maxHealth;

  @Getter
  private int currentHealth;

  private PlayerController controller = new PlayerController(this);

  private int iFramesLeft = 0;

  private boolean isDead = false;

  Player(double x, double y, Node sprite, int maxHealth, float speed) {
    super(x, y, sprite);
    this.setTag(Tags.PLAYER_TAG);
    this.setSpeed(speed);
    this.maxHealth = maxHealth;
    this.currentHealth = maxHealth;
  }

  @Override
  public void update() {
    super.update();
    for (GameObject i : App.gameObjects) {
      if (i.isColliding(this) && i.getTag() == Tags.ENEMY_TAG) {
        takeDamage(1);
      }
    }
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
    this.setCurrentHealth(getCurrentHealth() - 1);
    System.out.println("took " + amount + " damage");

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

  public void setCurrentHealth(int x){
    if(x > maxHealth){
      x = maxHealth;
    }
    currentHealth = x;
    App.UI.healthBar.update(currentHealth);
  }
}