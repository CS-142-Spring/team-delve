package Game;

import Engine.Engine;
import Game.Room;
import java.util.Random;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import org.yaml.snakeyaml.*;
import org.yaml.snakeyaml.constructor.Constructor;

import Game.Scenes.GameScene;
import Game.*;

public class GameMap {

    private static List<Room> rooms;
    private static Room currentRoom;
    private static int roomsVisited;

    public GameMap(int lenght) {

        Random rand = new Random();

        roomsVisited = 0;
        rooms = new ArrayList<>();

        for (int i = 0; i < lenght; i++) {
            
            // Random chance that room has a totem.
            int hasTotemChance = rand.nextInt(10);
            boolean hasTotem = (hasTotemChance >= 8);

            Room newRoom = new Room(hasTotem);

            // Add room to map.
            rooms.add(newRoom);
        }

        currentRoom = rooms.get(0);
        currentRoom.enter();
    }

    public static void enterNextRoom() {

        if (roomsVisited < (rooms.size() - 1)) { // Make sure we are not at the end of the map.

            currentRoom = rooms.get(roomsVisited + 1);
            currentRoom.enter();
            roomsVisited++;
        } else { // Last room? You win!
            Engine.switchScene("Win Scene");
        }
    }

    public static Room getCurrentRoom() {
        return currentRoom;
    }

}
