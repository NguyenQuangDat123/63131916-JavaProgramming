import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import java.io.File;

public class MusicPlayer extends Application {
    private MediaPlayer mediaPlayer;

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        Button playButton = new Button("▶ Play");
        Button pauseButton = new Button("⏸ Pause");
        Button stopButton = new Button("⏹ Stop");

        // Đường dẫn đến file nhạc trong thư mục của bạn
        String musicPath = "D:/Music/song.mp3";  // Thay đổi theo đường dẫn thực tế

        File musicFile = new File(musicPath);
        if (!musicFile.exists()) {
            System.out.println("File nhạc không tồn tại: " + musicPath);
            return;
        }

        Media media = new Media(musicFile.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);

        // Nút Play
        playButton.setOnAction(e -> mediaPlayer.play());
        // Nút Pause
        pauseButton.setOnAction(e -> mediaPlayer.pause());
        // Nút Stop
        stopButton.setOnAction(e -> mediaPlayer.stop());

        root.getChildren().addAll(mediaView, playButton, pauseButton, stopButton);

        Scene scene = new Scene(root, 300, 200);
        primaryStage.setTitle("Simple Music Player");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

