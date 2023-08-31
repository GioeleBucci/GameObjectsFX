import javafx.animation.AnimationTimer;

public class Updater {
    private long lastUpdateNanoTime = 0;
    private static final int UPDATES_PER_SECOND = App.FPS;
    private static final double UPDATE_INTERVAL = 1.0 / UPDATES_PER_SECOND;

    public Updater() {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long currentNanoTime) {
                if (lastUpdateNanoTime == 0) {
                    lastUpdateNanoTime = currentNanoTime;
                    return;
                }

                double elapsedSeconds = (currentNanoTime - lastUpdateNanoTime) / 1_000_000_000.0;

                if (elapsedSeconds > UPDATE_INTERVAL) {
                    System.out.println("Hello, World!");
                    lastUpdateNanoTime = currentNanoTime;
                }
            }
        };

        timer.start();
    }
}
