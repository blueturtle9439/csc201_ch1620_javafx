package sample;

import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.geometry.Insets;

public class StopWatch extends StackPane {

    private int H;
    private int M;
    private int S;
    private Text ShowingNum = new Text();
    private Timeline motion;

    public StopWatch() {
        setPadding(new Insets(5, 15, 5, 15));
        clear();
        ShowingNum.setFont(Font.font(30));
        getChildren().add(ShowingNum);
        motion = new Timeline(
                new KeyFrame(Duration.millis(1000), e -> run()));
        motion.setCycleCount(Timeline.INDEFINITE);
    }

    public void play() {
        motion.play();
    }

    public void pause() {
        motion.pause();
    }

    protected void run() {
        if (M == 59)
            H = H + 1;

        if (S == 59)
            M = M + 1;

        S = S < 59 ? S + 1 : 0;

        ShowingNum.setText(getTime());
    }

    public void clear() {
        H = 0;
        M = 0;
        S = 0;
        ShowingNum.setText(getTime());
    }

    private String getTime() {
        return pad(H) + ":" + pad(M) + ":" + pad(S);
    }

    private String pad(int n) {
        return n < 10 ? "0" + n : n + "";
    }
}
