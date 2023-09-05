import core.ImageUtils;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class UI_HealthBar extends HBox {

  private ImageView[] icons;

  public UI_HealthBar() {
    super();

    App.UI.getChildren().add(this);

    int amount = 0;
    for (GameObject i : App.gameObjects) {
      if (i instanceof Player) {
        amount = ((Player) i).getMaxHealth();
      }
    }
    assert amount == 0;

    icons = new ImageView[amount];
    for (int i = 0; i < icons.length; i++) {
      icons[i] = ImageUtils.newImgView("heartContainer.png");
      this.getChildren().add(icons[i]);
    }
  }

  public void update(int currentHealth) {
    if (currentHealth < 0) { // avoud out of bounds writing
      currentHealth = 0;
    }
    for (int i = currentHealth; i < icons.length; i++) {
      setEmpty(i);
    }
  }

  private void setEmpty(int index) {
    // create a black overlay for image and apply it to current container
    ColorAdjust colorAdjust = new ColorAdjust();
    colorAdjust.setBrightness(-1);
    this.icons[index].setEffect(colorAdjust);
  }
}