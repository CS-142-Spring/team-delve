package Game;

import java.util.Random;

public class NPC {
    public NPC(String[] args)

    {
        int NPC_selector = 0;
        Random NPC_dice = new Random();
        for (int counter = 1; counter <= 4; counter++) {
            NPC_selector = 1 + NPC_dice.nextInt(4);
        }

        int NPC_Strength = 0; // this is for the monsters added strength of the attack
        int NPC_Health;
        if (NPC_selector == 1) {
            String NPC = "skeleton";// changes string to current NPC
            System.out.println("there is a " + NPC+ " in the room");// prints what is in room
            NPC_Strength = 3;// changes the value of the npcs extra attack
            NPC_Health = 20; //changes npcs health base on what it is
        }
        else if (NPC_selector == 2) {
            String NPC = "slime";
            System.out.println("there is a " + NPC + " in the room");
            NPC_Strength = 1;
            NPC_Health = 10;
        }
        else if (NPC_selector == 3) {
            String NPC = "zombie";
            System.out.println("there is a " + NPC +" in the room");
            NPC_Strength = 2;
            NPC_Health = 30;
        }
        else if (NPC_selector == 4) {
            String NPC = "undead mage";
            System.out.println("there is a " + NPC+ " in the room");
            NPC_Strength = 7;
            NPC_Health = 40;
        }
        else  {
            System.out.println("there is nothing alive in the room");
        }
        int attack;// starting roll for attacking with random rolls
        Random attack_dice = new Random();// simple dice roll for attack
        for (int counter = 1; counter <= 6; counter++) {
            attack = 1 + NPC_Strength + attack_dice.nextInt(6);
        }
    }
}