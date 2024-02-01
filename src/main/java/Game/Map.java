package Game;

import java.util.Random;

public class Map {

    private Room startRoom;

    public Map(int rooms) {
        this.startRoom = generate(rooms);
    }

    private Room generate(int depth) {

        if (depth < 0) return null;

        Random rand = new Random();

        Room currentRoom = new Room(depth);
        if (depth > 0) {

            int exitAmount = rand.nextInt(2) + 1;

            currentRoom.exitLeft = generate(depth-1);
            if (exitAmount == 2) {
                currentRoom.exitRight = generate(depth-1);
            }
        }

        return currentRoom;
    }

}
