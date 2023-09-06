import core.Tags;
import javafx.scene.Node;

public class Pickup extends GameObject {

  private Player player;

  public Pickup(double x, double y, Node sprite) {
    super(x, y, sprite);
    this.setTag(Tags.HEALTH_PICKUP_TAG);
    this.player = findPlayer();
  }

  // put this in an interface maybe?
  /*
   * TODO currently the destroy method suck and this check is just
   * a workaround because it doesnt really get destroyed but just turns
   * invisible
   */
  public void onPickup(Player target) {
    if (this.getSprite().isVisible() == false) {
      return;
    }
    this.destroy();
    target.setCurrentHealth(target.getCurrentHealth() + 1);
    App.UI.healthBar.update(target.getCurrentHealth());
  }

  private Player findPlayer() {
    for (GameObject i : App.gameObjects) {
      if (i instanceof Player) {
        return (Player) i;
      }
    }
    return null;
  }
}
