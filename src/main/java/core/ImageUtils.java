package core;

import java.io.InputStream;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public final class ImageUtils {

  public static ImageView newImgView(String name) {
    ImageUtils utils = new ImageUtils();
    InputStream path = utils.getClass().getClassLoader().getResourceAsStream(name);
    ImageView imageView = new ImageView(new Image(path));
    return imageView;
  }


}
