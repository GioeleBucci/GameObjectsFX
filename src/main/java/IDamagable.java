public interface IDamagable {

  /**
   * Invulnerability duration (in seconds).
   * Determines the amount of IFrames
   */
  public static final double I_TIME = .8;

  /*
   * DO NOT MODIFY this variable directly:
   * to change the invulnerability duration, change I_TIME
   * instead
   */
  public static final int MAX_IFRAMES = (int) (App.FPS * I_TIME);

  void takeDamage(int amount);

}
