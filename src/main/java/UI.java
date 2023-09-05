import javafx.scene.layout.Pane;

/** Root to all UI elements */
public class UI extends Pane{

  public UI_HealthBar healthBar;

  public void init(){
    App.root.getChildren().add(this);
    healthBar = new UI_HealthBar();
  }
}