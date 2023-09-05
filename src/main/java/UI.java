import core.*;

import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class UI {
  public UI() {
    Pane canvas = new HBox();
    App.root.getChildren().add(canvas);

    canvas.setPrefSize(200, 200);

    ImageView[] healthBar = new ImageView[3];
    for (int i = 0; i < healthBar.length; i++) {
      healthBar[i] = ImageUtils.newImgView("heartContainer.png");
      canvas.getChildren().add(healthBar[i]);
    }

    // create a black overlay for image and apply it to the last container
    ColorAdjust colorAdjust = new ColorAdjust();
    colorAdjust.setBrightness(-1);
    healthBar[healthBar.length - 1].setEffect(colorAdjust);
  }
}