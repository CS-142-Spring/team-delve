package Game;

import java.util.List;

import Game.Scenes.GameScene;

import java.util.ArrayList;
import java.util.LinkedList;

public class Room {

    private boolean isTrap;
    private boolean isStart;
    private boolean isExit;

    // A room description/message that will be displayed when entering the room.
    private String description;
    private List<Item> items = new ArrayList<>();
    private List<NPC> npcs = new ArrayList<>();

    public int roomDepth;
    public Room exitLeft;
    public Room exitRight;

    private Room parent;
    private List<Room> exits;

    public Room() {

        this.exits = new LinkedList<>();
    }

    public Room addExit() {

        Room exit = new Room();
        exit.parent = this;
        this.exits.add(exit);

        return exit;
    }

    public void enter() {

        if (exitRight != null) {
            GameScene.addTextLine("On the back wall you see two doors.");
        } else {
            GameScene.addTextLine("On the back wall you see a door.");
        }
    }
}
