package Game;

import java.util.Map;
import java.util.Random;

import Game.Scenes.GameScene;

import java.util.HashMap;

public class Room {

    private boolean hasTotem;

    private Map<String, NPC> npcs = new HashMap<>();

    public Room(boolean hasTotem) {

        this.hasTotem = hasTotem;
    }

    public void addNPC(NPC npc) {
        npcs.put(npc.getType(), npc);
    }

    // Get NPC from the NPC map.
    public NPC getNPC(String type) {
        return npcs.get(type);
    }

    public void enter() {

        Random rand = new Random();

        GameScene.resetRoomItems();
        GameScene.setHasTotem(hasTotem);

        // Add a random amount of enemies.
        int npcAmount = rand.nextInt(5 - 1) + 1;

        for (int i = 0; i < npcAmount; i++) {

            NPC enemy = NPC.randomEnemy();
            addNPC(enemy);
        }

        // Add the enemies to the GameScene enemy interface list.
        for (Map.Entry<String, NPC> entry : npcs.entrySet()) {
            NPC val = entry.getValue();
            GameScene.addNPC(val);
        }

        // Set game options depending on if there is a totem.
        if (hasTotem) {
            GameScene.setOptions("Door", "Totem");
        } else {
            GameScene.setOptions("Door");
        }

        // Display entrance message.
        GameScene.setText("You walk into the room.");
        GameScene.addTextLine("You see a door on the back wall.");
        if (hasTotem) {
            GameScene.addTextLine("Next to the door you see a totem.");
        }

        // Decrease player health if the player is starving.
        if (Player.getHunger() <= 0) {
            
            GameScene.addTextLine("You are starving! (-10 HP)");
            Player.setHealth(Player.getHealth() - 10);
            GameScene.updateHPLabel();
        }
    }
}
