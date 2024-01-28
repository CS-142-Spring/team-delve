package Engine;

import java.util.ArrayList;
import java.util.List;
import static com.raylib.Jaylib.*;

public class Engine {

    List<Sound> sounds = new ArrayList<>();

    public Engine(int width, int height) {

        InitWindow(width, height, "Delve");
        SetTargetFPS(60);
        InitAudioDevice();
    }

    public void update() {

        while (!WindowShouldClose()) {

            // Update all sounds.
            for (Sound sound : sounds) {
                sound.update();
            }

            BeginDrawing();
            ClearBackground(BLACK);
            EndDrawing();
        }
    }

    public void cleanup() {

        // Destroy all sound resources.
        for (Sound sound : sounds) {
            sound.stop();
            sound.destroy();
        }

        CloseAudioDevice();
        CloseWindow();
    }

    public Sound newSound(String source, boolean stream) {
        sounds.add(new Sound(source, stream));
        return sounds.get(sounds.size() - 1);
    }
}
