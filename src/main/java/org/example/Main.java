package org.example;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Main extends Application {
    String URL_PAUSE_SOUND = "/sounds/pause.wav";
    String URL_RUN_SOUND = "/sounds/run.wav";

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("POMIDORRO");
        primaryStage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/tomato.png"))));
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 400,130);
        root.setStyle("-fx-background-color: #A60000;" + "-fx-padding: 30px,0px,0px,0px;");
        root.setAlignment(Pos.CENTER);
        primaryStage.setScene(scene);
        HBox hbox = new HBox();
        Label timerLabel = new Label("00:00");
        try {
            timerLabel.setFont(javafx.scene.text.Font.loadFont(getClass().getResourceAsStream("/fonts/Orbitron-VariableFont_wght.ttf"), 70));

        } catch (Exception e) {System.out.println("ERROR can't download font");}

        timerLabel.setStyle("-fx-text-fill: #008500;" );
        startTimer(timerLabel);
        hbox.getChildren().add(timerLabel);
        hbox.setAlignment(Pos.TOP_CENTER);
        root.getChildren().add(hbox);
        primaryStage.show();
    }

    private void startTimer(Label timerLabel) {
        AtomicInteger seconds = new AtomicInteger();
        AtomicInteger minutes = new AtomicInteger();
        Timeline timeLine = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            seconds.getAndIncrement();
            if (seconds.get() == 60) {
                seconds.set(0);
                minutes.getAndIncrement();
                if ((minutes.get() == 25 || minutes.get() == 55) && seconds.get() == 0) {
                    playMusic(URL_PAUSE_SOUND);
                }
                if ((minutes.get() == 30 || minutes.get() == 60) && seconds.get() == 0) {
                    minutes.set(0);
                    playMusic(URL_RUN_SOUND);
                }
            }
            timerLabel.setText(String.format("%02d:%02d", minutes.get(), seconds.get()));
        }));
        timeLine.setCycleCount(Timeline.INDEFINITE);
        timeLine.play();
    }

    private void playMusic(String str) {
        URL url = getClass().getResource(str);
        if (url == null) {
            System.out.println("Wrong path to file or file unavailable");
            return;
        }
        MediaPlayer mediaPlayerPause = new MediaPlayer(
                new Media(url.toString())
        );
        mediaPlayerPause.play();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}