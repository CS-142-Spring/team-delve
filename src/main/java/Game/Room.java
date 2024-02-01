package Game;

import java.util.List;
import java.util.ArrayList;

public class Room {

    private boolean isTrap;
    private boolean isExit;

    // A room description/message that will be displayed when entering the room.
    private String description;
    private List<Item> items = new ArrayList<>();
    private List<NPC> npcs = new ArrayList<>();

    public int roomDepth;
    public Room exitLeft;
    public Room exitRight;

    public Room(int depth) {

        roomDepth = depth;
        exitRight = null;
        exitLeft = null;

    }
}
