package Game;

import java.util.List;

import Game.Scenes.GameScene;

import java.util.ArrayList;
import java.util.LinkedList;

public class Room {

    private boolean hasTrapExit;
    private boolean isStart;
    private boolean isExit;

    // A room description/message that will be displayed when entering the room.
    private String description;
    private List<Item> items = new ArrayList<>();
    private List<NPC> npcs = new ArrayList<>();

    public Room(boolean hasTrapExit) {

        this.hasTrapExit = hasTrapExit;
    }

    public void enter() {
        System.out.println(this);

        if (hasTrapExit) {
            GameScene.setOptions("Door", "Totem");
        } else {
            GameScene.setOptions("Door");
        }

        GameScene.setText("You walk into the room.");
        GameScene.addTextLine("You see a door on the back wall.");
        if (hasTrapExit) {
            GameScene.addTextLine("Next to the door you see a totem.");
        }
    }
}
