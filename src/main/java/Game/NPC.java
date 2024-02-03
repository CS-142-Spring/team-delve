package Game;

import java.util.ArrayList;
import java.util.Random;

public class NPC {
    public static void main(String[] args) {
        ArrayList<String> NPC = new ArrayList<>();//adding the multiple NPCs to the list
        {
            NPC.add("skeleton");
            NPC.add("slime");
            NPC.add("zombie");
            NPC.add("undead mage");
        }
        Random attack_dice = new Random();// simple dice roll for attack
        int attack;
        for (int counter = 1; counter <= 6; counter++) {
            attack = 1 + attack_dice.nextInt(6);
        }
        Random health_dice = new Random();//rolling for health
        int health;
        for (int counter = 5; counter <= 10; counter++) {
            health = 10 + health_dice.nextInt(6);
        }
    }
}
