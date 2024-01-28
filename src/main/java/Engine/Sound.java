package Engine;

import static com.raylib.Jaylib.*;

public class Sound {

    private final String soundType; // sound or music.
    private final Music music;

    public Sound(String source, String type) {
        music = LoadMusicStream(source);
        soundType = type;
    }

    public void stream() {
        if (soundType.equals("music")) {
            PlayMusicStream(music);
        } else {
            System.out.println("This sound is not a music source.");
        }
    }

    public void stop() {
        StopMusicStream(music);
    }

    public void update() {
        UpdateMusicStream(music);
    }

    public void destroy() {
        if (soundType.equals("music")) {
            UnloadMusicStream(music);
        }
    }

}
