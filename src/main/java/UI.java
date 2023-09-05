import javafx.scene.layout.Pane;

public class UI extends Pane{

  public UI_HealthBar healthBar;

  public UI() {

  }

  public void init(){
    App.root.getChildren().add(this);
    healthBar = new UI_HealthBar();
  }
}