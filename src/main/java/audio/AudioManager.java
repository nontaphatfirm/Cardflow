package audio;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

import java.util.HashMap;
import java.util.Map;

public class AudioManager {

    public static final AudioManager INSTANCE = new AudioManager();
    public final MediaView mediaView;

    private static class SoundEffectFiles {
        private static final String RESOURCE_DIR = "/asset/audio/sfx/";
        private static final String[] FILENAMES = {
                "button-click",
                "card-effect-1",
                "card-effect-2",
                "card-effect-3",
                "card-move",
                "card-spawn",
                "game-error",
                "game-win",
                "mover-place",
                "mover-rotate"
        };

        private static final Map<String, AudioClip> audios = new HashMap<>();

        static {
            for (String filename: FILENAMES) {
                 audios.put(filename, new AudioClip( AudioManager.class.getResource(RESOURCE_DIR + filename + ".wav").toExternalForm()));
            }
        }

    }

    private static class MusicFiles {
        private static final String RESOURCE_DIR = "/asset/audio/music/";
        private static final String[] FILENAMES = { "music-game", "music-menu", "music-win" };
        private static final Map<String, Media> medias = new HashMap<>();

        static {
            for (String filename: FILENAMES) {

                medias.put(filename, new Media( AudioManager.class.getResource(RESOURCE_DIR + filename + ".mp3").toExternalForm() ));
            }
        }
   }

    public void playSoundEffect(String name) {
        AudioClip selectedAudio = SoundEffectFiles.audios.get(name);
        selectedAudio.play();
    }

    public void playMusic(String name) {
        Media selectedMusic = MusicFiles.medias.get(name);
        MediaPlayer mediaPlayer = new MediaPlayer(selectedMusic);

        mediaView.setMediaPlayer(mediaPlayer);

        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }

    private void musicFadeIn(MediaPlayer player, double seconds, double targetVolume) {
        player.setVolume(0); // Start at silence
        player.play();       // Start playing

        Timeline fade = new Timeline(
                new KeyFrame(Duration.seconds(seconds),
                        new KeyValue(player.volumeProperty(), targetVolume)
                )
        );
        fade.play();
    }

    private void musicFadeOut(MediaPlayer player, double seconds) {
        Timeline fade = new Timeline(
                new KeyFrame(Duration.seconds(seconds),
                        new KeyValue(player.volumeProperty(), 0) // Target volume: 0
                )
        );

        // Optional: Stop the player once the fade finishes
        fade.setOnFinished(e -> player.stop());
        fade.play();
    }

    private AudioManager() {
        mediaView = new MediaView();
    }

}
