// Old interface (Target)
interface MediaPlayer {
    void play(String audioType, String fileName);
}

// Legacy class (Adaptee)
class Mp3Player implements MediaPlayer {
    @Override
    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing MP3 file: " + fileName);
        } else {
            System.out.println("Invalid format. Only MP3 supported.");
        }
    }
}

// New interface (Target)
interface AdvancedMediaPlayer {
    void playMp4(String fileName);
}

// Adapter class
class MediaAdapter implements MediaPlayer {
    AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter() {
        advancedMediaPlayer = new Mp4Player();
    }

    @Override
    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer.playMp4(fileName);
        } else {
            System.out.println("Invalid format. Only MP4 supported.");
        }
    }
}

// Concrete class to play MP4 (Adaptee)
class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing MP4 file: " + fileName);
    }
}

// Client code
public class AdapterPattern {
    public static void main(String[] args) {
        MediaPlayer mp3Player = new Mp3Player();
        mp3Player.play("mp3", "song.mp3");

        MediaPlayer mp4Player = new MediaAdapter();
        mp4Player.play("mp4", "video.mp4");
    }
}
