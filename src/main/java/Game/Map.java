package Game;

import java.util.Random;

import Game.Scenes.GameScene;

public class Map {

    private Room root;
    private static Room currentRoom;

    public Map(int rooms) {

        startRoom = generate(rooms);
        startRoom.enter();
        currentRoom = startRoom;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public static void enterLeft() {
        if (currentRoom.exitLeft != null) {
            currentRoom.exitLeft.enter();
        }
    }

    public static void enterRight() {
        if (currentRoom.exitRight != null) {
            currentRoom.exitRight.enter();
        }
    }

    // A generate function that creates a random map of rooms.
    // The map is a binary tree, where each room has a 50% chance of having a left and right exit.

    private Room startRoom;

    private Room generate(int rooms) {

        Random rand = new Random();

        this.root = new Room();

        return root;
    }

}
