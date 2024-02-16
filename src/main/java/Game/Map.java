package Game;

import java.util.Random;

import Game.Scenes.GameScene;

public class Map {

    private static Room currentRoom;

    private int rooms[][];

    public Map(int size) {

        rooms = new int[size][size];

        int x = 0;
        int y = 0;

        int length = size;
        for (int i = 0; i < length; i++) {

            rooms[y][x] = 1;

            int dir = (int) ((Math.random() * (5 - 1)) + 1);
            switch (dir) {
                case 1:
                    if (y > 0) y--; break;
                case 2:
                    if (y < size) y++; break;
                case 3:
                    if (x > 0) x--; break;
                case 4:
                    if (x < size) x++; break;
            }
        }

        // debugPrint();

        // startRoom = generate(rooms);
        // startRoom.enter();
        // currentRoom = startRoom;
    }

    public void debugPrint() {

        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms.length; j++) {

                System.out.print(rooms[i][j]);
            }
            System.out.println("");
        }
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

    // private Room generate(int rooms) {
    //
    //     Random rand = new Random();
    // }

}
