package Game;

import java.util.Random;

public class NPC {

    private String type;
    private int accuracy;
    private int strenght;
    private int health;

    public NPC(String type, int strenght, int accuracy, int health) {

        // Initialize properties.
        this.type = type;
        this.strenght = strenght;
        this.accuracy = accuracy;
        this.health = health;
    }

    public String getType() {
        return this.type;
    }

    public int getHealth() {
        return health;
    }

    public int attack() {

        Random attackDice = new Random();// simple dice roll for attack

        // Generate random attack value.
        int max = this.strenght;
        int min = this.strenght - this.accuracy;
        int attackValue = attackDice.nextInt(max - min) + min;

        return attackValue;
    }

    // Generate a ranom enemy.
    public static NPC randomEnemy() {

        Random rand = new Random();

        NPC npc = new NPC("Slime", 5, 3, 10);
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
        }

        return npc;
    }

    public void hit(int hp) {
        this.health -= hp;
    }
}

