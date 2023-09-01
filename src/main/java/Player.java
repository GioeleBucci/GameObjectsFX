import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import lombok.Getter;
import lombok.Setter;

public class Player extends GameObject implements IDamagable {

  @Getter
  @Setter
  private int maxHealth;
  @Getter
  @Setter
  private int currentHealth = maxHealth;

  private int iFramesLeft = 0;

  Player(int maxHealth) {
    super(new Rectangle(40, 20, Color.BLUE));
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