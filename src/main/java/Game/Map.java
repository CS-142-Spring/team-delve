package Game;

import Engine.Engine;
import Game.Room;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

import Game.Scenes.GameScene;

public class Map {

    private static List<Room> rooms;
    private static Room currentRoom;
    private static int roomsVisited;

    public Map(int size) {

        roomsVisited = 0;
        Random rand = new Random();

        rooms = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            
            int hasTrapExitChance = rand.nextInt(10 - 0 + 1);
            boolean hasTrapExit = (hasTrapExitChance >= 7);

            Room newRoom = new Room(hasTrapExit);
            rooms.add(newRoom);

            System.out.println(hasTrapExit);
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
            Engine.switchScene("End Scene");
        }
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    // A generate function that creates a random map of rooms.
    // The map is a binary tree, where each room has a 50% chance of having a left and right exit.

    // private Room generate(int rooms) {
    //
    //     Random rand = new Random();
    // }

}
