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

class ItemData {
    public String name;
    public String type;
    public String description;
}

public class GameMap {

    private static List<Room> rooms;
    private static Room currentRoom;
    private static int roomsVisited;

    public GameMap(int size) {

        roomsVisited = 0;
        Random rand = new Random();

        rooms = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            
            int hasTotemChance = rand.nextInt(10);
            boolean hasTotem = (hasTotemChance >= 8);

            Room newRoom = new Room(hasTotem);

            rooms.add(newRoom);
        }

        currentRoom = rooms.get(0);
        currentRoom.enter();
    }

    public static void enterNextRoom() {

        if (roomsVisited < (rooms.size() - 1)) {

            currentRoom = rooms.get(roomsVisited + 1);
            currentRoom.enter();
            roomsVisited++;
        } else {
            Engine.switchScene("Win Scene");
        }
    }

    public static Room getCurrentRoom() {
        return currentRoom;
    }

    // A generate function that creates a random map of rooms.
    // The map is a binary tree, where each room has a 50% chance of having a left and right exit.

    // private Room generate(int rooms) {
    //
    //     Random rand = new Random();
    // }

}
