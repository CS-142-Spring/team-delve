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

    public NPC getNPC(String type) {
        return npcs.get(type);
    }

    public void enter() {

        Random rand = new Random();

        int npcAmount = rand.nextInt(5 - 1) + 1;

        NPC npc = new NPC("Slime", 5, 3, 10);
        GameScene.resetRoomItems();
        GameScene.setHasTotem(hasTotem);

        for (int i = 0; i < npcAmount; i++) {

            int npcType = rand.nextInt(3) + 1;
            switch (npcType) {
                case 1:
                    npc = new NPC("Slime", 5, 3, 10);
                    break;
                case 2:
                    npc = new NPC("Skeleton", 10, 3, 10);
                    break;
                case 3:
                    npc = new NPC("Zombie", 15, 8, 12);
                    break;

                default:
                    break;
            }
            
            addNPC(npc);
        }

        for (Map.Entry<String, NPC> entry : npcs.entrySet()) {
            NPC val = entry.getValue();
            GameScene.addNPC(val);
        }

        if (hasTotem) {
            GameScene.setOptions("Door", "Totem");
        } else {
            GameScene.setOptions("Door");
        }

        GameScene.setText("You walk into the room.");
        GameScene.addTextLine("You see a door on the back wall.");
        if (hasTotem) {
            GameScene.addTextLine("Next to the door you see a totem.");
        }
    }
}
