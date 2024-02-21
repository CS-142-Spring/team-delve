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
            GameScene.setOptions("Left Door", "Right Door");
        } else {

            GameScene.setOptions("Door");
        }

        GameScene.setText(this.toString());
    }
}
