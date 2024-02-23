package Game;

import java.util.Random;

public class NPC {

    private String type;
    private int accuracy;
    private int strenght; // this is for the monsters added strength of the attack
    private int health;

    public NPC(String type, int strenght, int accuracy, int health) {

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

        int max = this.strenght;
        int min = this.strenght - this.accuracy;
        int attackValue = attackDice.nextInt(max - min) + min;

        return attackValue;
    }

    public void hit(int hp) {
        this.health -= hp;
    }
}

