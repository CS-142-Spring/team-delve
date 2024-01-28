package Engine;

import static com.raylib.Jaylib.*;

public class Sound {

    private final boolean isStream; // Music is streamed, regular sounds are not.
    private final Music music;

    public Sound(String source, boolean stream) {
        music = LoadMusicStream(source);
        isStream = stream;
    }

    public void stream() {
        if (isStream) {
            PlayMusicStream(music);
        } else {
            System.out.println("ERROR: This sound is not streamable.");
        }
    }

    public void stop() {
        StopMusicStream(music);
    }

    public void update() {
        UpdateMusicStream(music);
    }

    public void destroy() {
        if (isStream) {
            UnloadMusicStream(music);
        }
    }

}
