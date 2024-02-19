package Game;

import java.util.ArrayList;
import java.util.Random;

public class NPC {
     public NPC(String[] args) {
         //adding the multiple NPCs to the list
         Random attack_dice = new Random();// simple dice roll for attack
         String NPC;
         NPC = "skeleton";
         int attack;
         int accuracy=0;
         int NPC_Strength = 0; // this is for the monsters added strength of the attack
         int NPC_Health;
         if (NPC  == "skeleton"){
             System.out.println("there is a skeleton in the room");
             NPC_Strength= 3;
             NPC_Health = 20;
         }
         else if (NPC == "slime") {
             System.out.println("there is a slime in the room");
             NPC_Strength = 1;
             NPC_Health = 10;
         }
         else if (NPC == "zombie"){
             System.out.println("there is a zombie in the room");
             NPC_Strength= 2;
             NPC_Health = 30;
         }
         else  if (NPC == "undead mage") {
             System.out.println("there is a zombie in the room");
             NPC_Strength = 7;
             NPC_Health = 40;
         }
         else {
             System.out.println("there is nothing alive in the room");
         }
         if (accuracy>10) {
             for (int counter = 1; counter <= 6; counter++) {
                 attack = NPC_Strength + attack_dice.nextInt(6);

             }
         }
         else {
             System.out.println("The "+NPC+"s attack missed");
         }

     }
}

